package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.PersonaDiscapacidad;
import com.usco.edu.rowMapper.PersonaDiscapacidadRowMapper;

public class PersonaDiscapacidadSetExtractor implements ResultSetExtractor<List<PersonaDiscapacidad>>{

	@Override
	public List<PersonaDiscapacidad> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<PersonaDiscapacidad> list = new ArrayList<PersonaDiscapacidad>();
		while (rs.next()) {
			list.add(new PersonaDiscapacidadRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}

}