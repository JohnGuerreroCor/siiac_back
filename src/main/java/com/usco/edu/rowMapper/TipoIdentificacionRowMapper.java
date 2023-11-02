package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.TipoIdentificacion;

public class TipoIdentificacionRowMapper implements RowMapper<TipoIdentificacion>{

	@Override
	public TipoIdentificacion mapRow(ResultSet rs, int rowNum) throws SQLException {
		TipoIdentificacion tipoId = new TipoIdentificacion();
		tipoId.setCodigo(rs.getInt("tii_codigo"));
		tipoId.setNombre(rs.getString("tii_nombre"));
		tipoId.setNombreCorto(rs.getString("tii_nombre_corto"));
		tipoId.setEstado(rs.getInt("tii_estado"));
		return tipoId;
	}

}