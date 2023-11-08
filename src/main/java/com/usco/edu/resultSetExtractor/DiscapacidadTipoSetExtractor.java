package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.DiscapacidadTipo;
import com.usco.edu.rowMapper.DiscapacidadTipoRowMapper;

public class DiscapacidadTipoSetExtractor implements ResultSetExtractor<List<DiscapacidadTipo>>{

	@Override
	public List<DiscapacidadTipo> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<DiscapacidadTipo> list = new ArrayList<DiscapacidadTipo>();
		while (rs.next()) {
			list.add(new DiscapacidadTipoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}

}