package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.FuncionesCuerpoColegiado;

public class FuncionesCuerpoColegiadoRowMapper implements RowMapper<FuncionesCuerpoColegiado>{

	@Override
	public FuncionesCuerpoColegiado mapRow(ResultSet rs, int rowNum) throws SQLException {
		FuncionesCuerpoColegiado funciones = new FuncionesCuerpoColegiado();
		funciones.setCodigo(rs.getInt("fcc_codigo"));
		funciones.setCuerpoColegiado(new CuerpoColegiadoRowMapper().mapRow(rs, rowNum));
		funciones.setNombre(rs.getString("fcc_nombre"));
		funciones.setEstado(rs.getInt("fcc_estado"));
		return funciones;
	}
}
