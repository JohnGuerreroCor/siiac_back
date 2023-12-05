package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.CuerpoColegiado;

public class CuerpoColegiadoRowMapper implements RowMapper<CuerpoColegiado>{

	@Override
	public CuerpoColegiado mapRow(ResultSet rs, int rowNum) throws SQLException {
		CuerpoColegiado cuerposColegiados = new CuerpoColegiado();
		cuerposColegiados.setCodigo(rs.getInt("cuc_codigo"));
		cuerposColegiados.setNombre(rs.getString("cuc_nombre"));
		cuerposColegiados.setNombreCorto(rs.getString("cuc_nombre_corto"));
		cuerposColegiados.setNumeroNorma(rs.getInt("cuc_numero_norma"));
		cuerposColegiados.setNombreNorma(rs.getString("cuc_nombre_norma"));
		cuerposColegiados.setFechaNorma(rs.getDate("cuc_fecha_norma"));
		cuerposColegiados.setFechaCreacion(rs.getDate("cuc_fecha_creacion"));
		cuerposColegiados.setCantidadMiembros(rs.getInt("cuc_cantidad_miembros"));
		cuerposColegiados.setEstado(rs.getInt("cuc_estado"));
		return cuerposColegiados;
	}

}
