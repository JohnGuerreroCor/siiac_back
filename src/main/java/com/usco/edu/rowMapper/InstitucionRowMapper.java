package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.Institucion;

public class InstitucionRowMapper implements RowMapper<Institucion>{

	@Override
	public Institucion mapRow(ResultSet rs, int rowNum) throws SQLException {
		Institucion institucion = new Institucion();
		institucion.setCodigo(rs.getInt("ins_codigo"));
		institucion.setNit(rs.getString("ins_nit"));
		institucion.setIes(rs.getInt("ins_snies"));
		institucion.setIesPadre(rs.getInt("ins_snies_padre"));
		institucion.setNaturaleza(new NaturalezaJuridicaRowMapper().mapRow(rs, rowNum));
		institucion.setSector(new SectorRowMapper().mapRow(rs, rowNum));
		institucion.setCaracter(new CaracterAcademicoRowMapper().mapRow(rs, rowNum));
		institucion.setNombre(rs.getString("ins_nombre"));
		institucion.setPais(new PaisRowMapper().mapRow(rs, rowNum));
		institucion.setDepartamento(new DepartamentoRowMapper().mapRow(rs, rowNum));
		institucion.setMunicipio(new MunicipioRowMapper().mapRow(rs, rowNum));
		institucion.setCcp(new CabecerasCentrosPobladosRowMapper().mapRow(rs, rowNum));
		institucion.setDireccion(rs.getString("ins_direccion"));
		institucion.setTelefono(rs.getString("ins_telefono"));
		institucion.setUrl(rs.getString("ins_pagina_web"));
		//institucion.setNormaCodigo(rs.getInt("nor_codigo"));
		//institucion.setNorma(rs.getString("not_nombre")+" "+rs.getString("nor_numero")+" "+rs.getString("nor_nombre"));
		institucion.setFechaNorma(rs.getDate("ins_fecha_norma"));
		institucion.setEstado(rs.getInt("ins_estado"));
		return institucion;
	}

}