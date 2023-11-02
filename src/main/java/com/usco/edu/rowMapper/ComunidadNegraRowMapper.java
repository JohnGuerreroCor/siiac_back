package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.ComunidadNegra;

public class ComunidadNegraRowMapper implements RowMapper<ComunidadNegra>{

	@Override
	public ComunidadNegra mapRow(ResultSet rs, int rowNum) throws SQLException {
		ComunidadNegra comunidadNegra = new ComunidadNegra();
		comunidadNegra.setCodigo(rs.getInt("con_codigo"));
		comunidadNegra.setNombre(rs.getString("con_nombre"));
		comunidadNegra.setEstado(rs.getInt("con_estado"));
		return comunidadNegra;
	}

}