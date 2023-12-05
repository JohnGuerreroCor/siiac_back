package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.NormaGrupo;
import com.usco.edu.rowMapper.NormaGrupoCantidadRowMapper;

public class NormaGrupoCantidadSetExtractor implements ResultSetExtractor<List<NormaGrupo>>{

	@Override
	public List<NormaGrupo> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<NormaGrupo> list = new ArrayList<NormaGrupo>();
		while (rs.next()) {
			list.add(new NormaGrupoCantidadRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
