package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.CabecerasCentrosPoblados;

public class CabecerasCentrosPobladosRowMapper implements RowMapper<CabecerasCentrosPoblados>{

	@Override
	public CabecerasCentrosPoblados mapRow(ResultSet rs, int rowNum) throws SQLException {
		CabecerasCentrosPoblados ccp = new CabecerasCentrosPoblados();
		ccp.setCodigo(rs.getInt("ccp_codigo"));
		ccp.setNombre(rs.getString("ccp_nombre"));
		ccp.setDivipola(rs.getString("ccp_divipola"));
		ccp.setTipo(rs.getString("ccp_tipo"));
		ccp.setMunicipio(new MunicipioRowMapper().mapRow(rs, rowNum));
		
		return ccp;
	}

}
