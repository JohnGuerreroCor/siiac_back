package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.AreaConocimiento;

public class AreaConocimientoRowMapper implements RowMapper<AreaConocimiento>{

	@Override
	public AreaConocimiento mapRow(ResultSet rs, int rowNum) throws SQLException {
		AreaConocimiento amplio = new AreaConocimiento();
		amplio.setCodigo(rs.getInt("arc_codigo"));
		amplio.setNombre(rs.getString("arc_nombre"));
		amplio.setEstado(rs.getInt("arc_estado"));
		return amplio;
	}
}
