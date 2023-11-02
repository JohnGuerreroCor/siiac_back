package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.PuebloIndigena;

public class PuebloIndigenaRowMapper implements RowMapper<PuebloIndigena>{

	@Override
	public PuebloIndigena mapRow(ResultSet rs, int rowNum) throws SQLException {
		PuebloIndigena estrato = new PuebloIndigena();
		estrato.setCodigo(rs.getInt("pui_codigo"));
		estrato.setNombre(rs.getString("pui_nombre"));
		estrato.setEstado(rs.getInt("pui_estado"));
		return estrato;
	}

}