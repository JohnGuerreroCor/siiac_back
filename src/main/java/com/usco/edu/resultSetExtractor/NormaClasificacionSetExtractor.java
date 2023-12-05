package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.NormaClasificacion;
import com.usco.edu.rowMapper.NormaClasificacionRowMapper;

public class NormaClasificacionSetExtractor implements ResultSetExtractor<List<NormaClasificacion>>{

	@Override
	public List<NormaClasificacion> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<NormaClasificacion> list = new ArrayList<NormaClasificacion>();
		while (rs.next()) {
			list.add(new NormaClasificacionRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
