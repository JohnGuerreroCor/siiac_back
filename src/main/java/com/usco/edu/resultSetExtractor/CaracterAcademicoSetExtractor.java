package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.CaracterAcademico;
import com.usco.edu.rowMapper.CaracterAcademicoRowMapper;

public class CaracterAcademicoSetExtractor implements ResultSetExtractor<List<CaracterAcademico>>{

	@Override
	public List<CaracterAcademico> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<CaracterAcademico> list = new ArrayList<CaracterAcademico>();
		while (rs.next()) {
			list.add(new CaracterAcademicoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}

}