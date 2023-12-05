package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.MiembroTipo;

public class MiembroTipoRowMapper implements RowMapper<MiembroTipo>{

	@Override
	public MiembroTipo mapRow(ResultSet rs, int rowNum) throws SQLException {
		MiembroTipo miembroTipo = new MiembroTipo();
		miembroTipo.setCodigo(rs.getInt("mit_codigo"));
		miembroTipo.setNombre(rs.getString("mit_nombre"));
		miembroTipo.setEstado(rs.getInt("mit_estado"));
		return miembroTipo;
		
	}
}
