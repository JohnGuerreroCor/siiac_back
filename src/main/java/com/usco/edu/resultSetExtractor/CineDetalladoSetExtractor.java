package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.CineDetallado;
import com.usco.edu.rowMapper.CineDetalladoRowMapper;

public class CineDetalladoSetExtractor implements ResultSetExtractor<List<CineDetallado>>{

	@Override
	public List<CineDetallado> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<CineDetallado> list = new ArrayList<CineDetallado>();
		while (rs.next()) {
			list.add(new CineDetalladoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
