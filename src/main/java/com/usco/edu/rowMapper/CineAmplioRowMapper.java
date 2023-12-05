package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.CineAmplio;

public class CineAmplioRowMapper implements RowMapper<CineAmplio>{

	@Override
	public CineAmplio mapRow(ResultSet rs, int rowNum) throws SQLException {
		CineAmplio amplio = new CineAmplio();
		amplio.setCodigo(rs.getInt("cac_codigo"));
		amplio.setNombre(rs.getString("cac_nombre"));
		amplio.setCine(rs.getString("cac_cine"));
		amplio.setEstado(rs.getInt("cac_estado"));
		return amplio;
	}
}
