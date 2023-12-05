package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.AreaConocimiento;
import com.usco.edu.rowMapper.AreaConocimientoRowMapper;

public class AreaConocimientoSetExtractor implements ResultSetExtractor<List<AreaConocimiento>>{

	@Override
	public List<AreaConocimiento> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<AreaConocimiento> list = new ArrayList<AreaConocimiento>();
		while (rs.next()) {
			list.add(new AreaConocimientoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
