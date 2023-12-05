package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.NivelFormacion;

public class NivelFormacionRowMapper implements RowMapper<NivelFormacion>{

	@Override
	public NivelFormacion mapRow(ResultSet rs, int rowNum) throws SQLException {
		NivelFormacion nivelFormacion = new NivelFormacion();
		nivelFormacion.setCodigo(rs.getInt("nif_codigo"));
		nivelFormacion.setNivelAcademicoCodigo(rs.getInt("nia_codigo"));
		nivelFormacion.setNivelAcademico(rs.getString("nia_nombre"));
		nivelFormacion.setNombre(rs.getString("nif_nombre"));
		nivelFormacion.setEstado(rs.getInt("nif_estado"));
		return nivelFormacion;
	}
}
