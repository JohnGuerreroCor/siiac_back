package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.TalentoExcepcional;

public class TalentoExcepcionalRowMapper implements RowMapper<TalentoExcepcional>{

	@Override
	public TalentoExcepcional mapRow(ResultSet rs, int rowNum) throws SQLException {
		TalentoExcepcional estrato = new TalentoExcepcional();
		estrato.setCodigo(rs.getInt("tae_codigo"));
		estrato.setNombre(rs.getString("tae_nombre"));
		estrato.setEstado(rs.getInt("tae_estado"));
		return estrato;
	}

}