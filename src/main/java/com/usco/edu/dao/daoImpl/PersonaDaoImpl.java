package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IPersonaDao;
import com.usco.edu.entities.PersonaCarnet;
import com.usco.edu.resultSetExtractor.PersonaSetExtractor;

@Repository
public class PersonaDaoImpl implements IPersonaDao  {
	
	@Autowired
	@Qualifier("JDBCTemplateUscoConsulta")
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public List<PersonaCarnet> buscarPorPerCodigo(int codigo) {

		String sql = "Select *, floor((cast(convert(varchar(8),getdate(),112) as int) - cast(convert(varchar(8), p.per_fecha_nacimiento ,112) as int) ) / 10000) as edad from persona p "
				+ "inner join tipo_id t on p.tii_codigo = t.tii_codigo "
				+ "inner join grupo_sanguineo gs on p.grs_codigo = gs.grs_codigo " 
				+ "where per_estado = 1 and per_codigo = " + codigo + " ";
		return jdbcTemplate.query(sql, new PersonaSetExtractor()); 
	}
	
	@Override
	public List<PersonaCarnet> buscarPorIdentificacion(String id) {

		String sql = "Select *, floor((cast(convert(varchar(8),getdate(),112) as int) - cast(convert(varchar(8), p.per_fecha_nacimiento ,112) as int) ) / 10000) as edad from persona p "
				+ "inner join tipo_id t on p.tii_codigo = t.tii_codigo "
				+ "inner join grupo_sanguineo gs on p.grs_codigo = gs.grs_codigo " 
				+ "where per_estado = 1 and per_identificacion = '" + id + "' ";
		return jdbcTemplate.query(sql, new PersonaSetExtractor());
	}

}
