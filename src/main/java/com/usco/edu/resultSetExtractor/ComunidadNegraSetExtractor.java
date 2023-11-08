package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.ComunidadNegra;
import com.usco.edu.rowMapper.ComunidadNegraRowMapper;

public class ComunidadNegraSetExtractor implements ResultSetExtractor<List<ComunidadNegra>>{

	@Override
	public List<ComunidadNegra> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<ComunidadNegra> list = new ArrayList<ComunidadNegra>();
		while (rs.next()) {
			list.add(new ComunidadNegraRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}

}