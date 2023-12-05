package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.Nbc;

public class NbcRowMapper implements RowMapper<Nbc>{

	@Override
	public Nbc mapRow(ResultSet rs, int rowNum) throws SQLException {
		Nbc nbc = new Nbc();
		nbc.setCodigo(rs.getInt("nbc_codigo"));
		nbc.setAreaConocimientoCodigo(rs.getInt("arc_codigo"));
		nbc.setAreaConocimiento(rs.getString("arc_nombre"));
		nbc.setCod(rs.getInt("nbc_cod"));
		nbc.setNombre(rs.getString("nbc_nombre"));
		nbc.setEstado(rs.getInt("nbc_estado"));
		return nbc;
	}
}
