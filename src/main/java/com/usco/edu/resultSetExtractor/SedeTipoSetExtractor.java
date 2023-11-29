package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.SedeTipo;
import com.usco.edu.rowMapper.SedeTipoRowMapper;

public class SedeTipoSetExtractor implements ResultSetExtractor<List<SedeTipo>>{

	@Override
	public List<SedeTipo> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<SedeTipo> list = new ArrayList<SedeTipo>();
		while (rs.next()) {
			list.add(new SedeTipoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}

}