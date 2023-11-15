package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.Sector;

public class SectorRowMapper implements RowMapper<Sector>{

	@Override
	public Sector mapRow(ResultSet rs, int rowNum) throws SQLException {
		Sector sector = new Sector();
		sector.setCodigo(rs.getInt("sec_codigo"));
		sector.setNombre(rs.getString("sec_nombre"));
		sector.setEstado(rs.getInt("sec_estado"));
		return sector;
	}

}