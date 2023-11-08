package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.PuebloIndigena;
import com.usco.edu.rowMapper.PuebloIndigenaRowMapper;

public class PuebloIndigenaSetExtractor implements ResultSetExtractor<List<PuebloIndigena>>{

	@Override
	public List<PuebloIndigena> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<PuebloIndigena> list = new ArrayList<PuebloIndigena>();
		while (rs.next()) {
			list.add(new PuebloIndigenaRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}

}