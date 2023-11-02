package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.DiscapacidadTipo;

public class DiscapacidadTipoRowMapper implements RowMapper<DiscapacidadTipo>{

	@Override
	public DiscapacidadTipo mapRow(ResultSet rs, int rowNum) throws SQLException {
		DiscapacidadTipo discapacidadTipo = new DiscapacidadTipo();
		discapacidadTipo.setCodigo(rs.getInt("dit_codigo"));
		discapacidadTipo.setNombre(rs.getString("dit_nombre"));
		discapacidadTipo.setEstado(rs.getInt("dit_estado"));
		return discapacidadTipo;
	}

}