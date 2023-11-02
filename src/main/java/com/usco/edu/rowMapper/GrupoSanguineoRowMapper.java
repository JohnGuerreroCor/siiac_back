package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.GrupoSanguineo;

public class GrupoSanguineoRowMapper implements RowMapper<GrupoSanguineo>{

	@Override
	public GrupoSanguineo mapRow(ResultSet rs, int rowNum) throws SQLException {
		GrupoSanguineo rh = new GrupoSanguineo();
		rh.setCodigo(rs.getInt("grs_codigo"));
		rh.setNombre(rs.getString("grs_nombre"));
		rh.setEstado(rs.getInt("grs_estado"));
		return rh;
	}

}