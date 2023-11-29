package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.SedeGeneral;
import com.usco.edu.rowMapper.SedeGeneralRowMapper;

public class SedeGeneralSetExtractor implements ResultSetExtractor<List<SedeGeneral>>{

	@Override
	public List<SedeGeneral> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<SedeGeneral> list = new ArrayList<SedeGeneral>();
		while (rs.next()) {
			list.add(new SedeGeneralRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
