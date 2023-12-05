package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.CuerpoColegiado;

public class CuerpoColegiadoDisponibilidadRowMapper implements RowMapper<CuerpoColegiado>{

	@Override
	public CuerpoColegiado mapRow(ResultSet rs, int rowNum) throws SQLException {
		CuerpoColegiado cuerposColegiados = new CuerpoColegiado();
		cuerposColegiados.setCodigo(rs.getInt("cuc_codigo"));
		cuerposColegiados.setNombre(rs.getString("cuc_nombre"));
		cuerposColegiados.setCantidadMiembros(rs.getInt("cuc_cantidad_miembros"));
		cuerposColegiados.setDisponibilidadMiembros(rs.getInt("asignados"));
		return cuerposColegiados;
	}
}
