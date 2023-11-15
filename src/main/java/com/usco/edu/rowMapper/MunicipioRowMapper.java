package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.Municipio;

public class MunicipioRowMapper implements RowMapper<Municipio>{

	@Override
	public Municipio mapRow(ResultSet rs, int rowNum) throws SQLException {
		Municipio municipio = new Municipio();
		municipio.setCodigo(rs.getInt("mun_codigo"));
		municipio.setNombre(rs.getString("mun_nombre"));
		municipio.setDivipola(rs.getString("mun_divipola"));
		municipio.setTipo(rs.getString("mun_tipo"));
		municipio.setArea(rs.getString("mun_area_metropolitana"));
		municipio.setDepartamento(new DepartamentoRowMapper().mapRow(rs, rowNum));
		
		return municipio;
	}
	
}
