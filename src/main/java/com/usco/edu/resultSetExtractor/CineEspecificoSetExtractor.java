package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.CineEspecifico;
import com.usco.edu.rowMapper.CineEspecificoRowMapper;

public class CineEspecificoSetExtractor implements ResultSetExtractor<List<CineEspecifico>>{

	@Override
	public List<CineEspecifico> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<CineEspecifico> list = new ArrayList<CineEspecifico>();
		while (rs.next()) {
			list.add(new CineEspecificoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
