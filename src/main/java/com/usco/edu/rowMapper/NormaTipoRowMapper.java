package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.NormaTipo;

public class NormaTipoRowMapper implements RowMapper<NormaTipo>{

	@Override
	public NormaTipo mapRow(ResultSet rs, int rowNum) throws SQLException {
		NormaTipo normaTipo = new NormaTipo();
		normaTipo.setCodigo(rs.getInt("not_codigo"));
		normaTipo.setNombre(rs.getString("not_nombre"));
		normaTipo.setEntidadCodigo(rs.getInt("noe_codigo"));
		normaTipo.setEntidad(rs.getString("noe_nombre"));
		normaTipo.setEstado(rs.getInt("not_estado"));
		return normaTipo;
	}
}
