package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.SedeTipo;

public class SedeTipoRowMapper implements RowMapper<SedeTipo>{

	@Override
	public SedeTipo mapRow(ResultSet rs, int rowNum) throws SQLException {
		SedeTipo sedeTipo = new SedeTipo();
		sedeTipo.setCodigo(rs.getInt("set_codigo"));
		sedeTipo.setNombre(rs.getString("set_nombre"));
		sedeTipo.setEstado(rs.getInt("set_estado"));
		return sedeTipo;
	}

}