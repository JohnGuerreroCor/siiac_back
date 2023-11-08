package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.CabecerasCentrosPoblados;
import com.usco.edu.rowMapper.CabecerasCentrosPobladosRowMapper;

public class CabecerasCentrosPobladosSetExtractor implements ResultSetExtractor<List<CabecerasCentrosPoblados>>{

	@Override
	public List<CabecerasCentrosPoblados> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<CabecerasCentrosPoblados> list = new ArrayList<CabecerasCentrosPoblados>();
		while (rs.next()) {
			list.add(new CabecerasCentrosPobladosRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}

}