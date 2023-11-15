package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.Sector;
import com.usco.edu.rowMapper.SectorRowMapper;

public class SectorSetExtractor implements ResultSetExtractor<List<Sector>>{

	@Override
	public List<Sector> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Sector> list = new ArrayList<Sector>();
		while (rs.next()) {
			list.add(new SectorRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}

}