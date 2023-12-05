package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.NivelFormacion;
import com.usco.edu.rowMapper.NivelFormacionRowMapper;

public class NivelFormacionSetExtractor implements ResultSetExtractor<List<NivelFormacion>>{

	@Override
	public List<NivelFormacion> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<NivelFormacion> list = new ArrayList<NivelFormacion>();
		while (rs.next()) {
			list.add(new NivelFormacionRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
