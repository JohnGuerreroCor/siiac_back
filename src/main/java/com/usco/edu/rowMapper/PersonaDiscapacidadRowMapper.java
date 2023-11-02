package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.PersonaDiscapacidad;

public class PersonaDiscapacidadRowMapper implements RowMapper<PersonaDiscapacidad>{

	@Override
	public PersonaDiscapacidad mapRow(ResultSet rs, int rowNum) throws SQLException {
		PersonaDiscapacidad estrato = new PersonaDiscapacidad();
		estrato.setCodigo(rs.getInt("ped_codigo"));
		estrato.setCondicion(rs.getString("ped_condicion"));
		estrato.setEstado(rs.getInt("ped_estado"));
		return estrato;
	}

}