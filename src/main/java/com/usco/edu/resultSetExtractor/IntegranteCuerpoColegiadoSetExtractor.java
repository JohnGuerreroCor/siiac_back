package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.IntegranteCuerpoColegiado;
import com.usco.edu.rowMapper.IntegranteCuerpoColegiadoRowMapper;

public class IntegranteCuerpoColegiadoSetExtractor implements ResultSetExtractor<List<IntegranteCuerpoColegiado>>{

	@Override
	public List<IntegranteCuerpoColegiado> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<IntegranteCuerpoColegiado> list = new ArrayList<IntegranteCuerpoColegiado>();
		while (rs.next()) {
			list.add(new IntegranteCuerpoColegiadoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
		
	}
	
}
