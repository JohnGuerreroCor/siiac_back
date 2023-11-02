package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.Usuario;


public class UsuarioRowMapper implements RowMapper<Usuario>{

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario user = new Usuario();
		user.setCodigo(rs.getInt("usu_codigo"));
		user.setPassword(rs.getString("uwd2"));
		user.setRole(rs.getString("usu_estado"));
		user.setUsername(rs.getString("usu_nombre"));
		user.setState(rs.getInt("usu_estado") > 0 ? true : false);
		user.setPersona(new PersonaUsuarioRowMapper().mapRow(rs, rowNum));
		return user;
	}

}
