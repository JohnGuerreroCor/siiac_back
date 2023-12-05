package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.CuerpoColegiado;
import com.usco.edu.rowMapper.CuerpoColegiadoDisponibilidadRowMapper;

public class CuerpoColegiadoDisponibilidadSetExtractor implements ResultSetExtractor<List<CuerpoColegiado>>{

	@Override
	public List<CuerpoColegiado> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<CuerpoColegiado> list = new ArrayList<CuerpoColegiado>();
		while (rs.next()) {
			list.add(new CuerpoColegiadoDisponibilidadRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
