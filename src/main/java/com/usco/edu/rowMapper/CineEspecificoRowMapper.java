package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.CineEspecifico;

public class CineEspecificoRowMapper implements RowMapper<CineEspecifico>{

	@Override
	public CineEspecifico mapRow(ResultSet rs, int rowNum) throws SQLException {
		CineEspecifico especifico = new CineEspecifico();
		especifico.setCodigo(rs.getInt("cec_codigo"));
		especifico.setNombre(rs.getString("cec_nombre"));
		especifico.setCine(rs.getString("cec_cine"));
		especifico.setAmplioCodigo(rs.getInt("cac_codigo"));
		especifico.setAmplioCine(rs.getString("cac_cine"));
		especifico.setAmplio(rs.getString("cac_nombre"));
		especifico.setEstado(rs.getInt("cec_estado"));
		return especifico;
	}
}
