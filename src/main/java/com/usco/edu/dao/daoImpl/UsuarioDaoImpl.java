package com.usco.edu.dao.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IUsuarioDao;
import com.usco.edu.entities.Usuario;
import com.usco.edu.rowMapper.UsuarioRowMapper;

@Repository
public class UsuarioDaoImpl implements IUsuarioDao{
	
	@Autowired
	@Qualifier("JDBCTemplateUscoConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public Usuario findByUsername(String username) {
		String sql = "SELECT * FROM dbo.vista_usuario_general vug "
				+ "WHERE vug.usu_nombre = ? AND vug.usu_estado = 1 ";
		return jdbcTemplate.queryForObject(sql, new Object[] { username }, new UsuarioRowMapper());
	}

	@Override
	public boolean validarUser(String username) {
		int result = 0;
		String sql = "select COUNT(usu_nombre) from dbo.vista_usuario_general " 
				+ "where usu_nombre = ? ";
		result =  jdbcTemplate.queryForObject(sql, new Object[] { username }, Integer.class);
		return result > 0 ? true : false;
	}

}
