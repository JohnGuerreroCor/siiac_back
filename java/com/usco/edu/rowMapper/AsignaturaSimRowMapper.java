package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.Asignatura;

public class AsignaturaSimRowMapper implements RowMapper<Asignatura>{

	@Override
	public Asignatura mapRow(ResultSet rs, int rowNum) throws SQLException {
		Asignatura asignatura = new Asignatura();
		asignatura.setCodigo(rs.getInt("asi_codigo"));
		asignatura.setCreditos(rs.getInt("asi_creditos"));
		asignatura.setEstado(rs.getInt("asi_estado"));
		asignatura.setExtramuro(rs.getString("asi_extramuro"));
		asignatura.setNombre(rs.getString("asi_nombre"));
		asignatura.setNombreCorto(rs.getString("asi_nombre_corto"));
		asignatura.setPublicar(rs.getString("asi_publicar"));
		return asignatura;
	}

}
