package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.NaturalezaJuridica;
import com.usco.edu.rowMapper.NaturalezaJuridicaRowMapper;

public class NaturalezaJuridicaSetExtractor implements ResultSetExtractor<List<NaturalezaJuridica>>{

	@Override
	public List<NaturalezaJuridica> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<NaturalezaJuridica> list = new ArrayList<NaturalezaJuridica>();
		while (rs.next()) {
			list.add(new NaturalezaJuridicaRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}

}