package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.NaturalezaJuridica;

public class NaturalezaJuridicaRowMapper implements RowMapper<NaturalezaJuridica>{

	@Override
	public NaturalezaJuridica mapRow(ResultSet rs, int rowNum) throws SQLException {
		NaturalezaJuridica naturalezaJuridica = new NaturalezaJuridica();
		naturalezaJuridica.setCodigo(rs.getInt("naj_codigo"));
		naturalezaJuridica.setNombre(rs.getString("naj_nombre"));
		naturalezaJuridica.setEstado(rs.getInt("naj_estado"));
		return naturalezaJuridica;
	}

}