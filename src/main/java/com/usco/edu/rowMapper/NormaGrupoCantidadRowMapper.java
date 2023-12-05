package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.NormaGrupo;

public class NormaGrupoCantidadRowMapper implements RowMapper<NormaGrupo>{

	@Override
	public NormaGrupo mapRow(ResultSet rs, int rowNum) throws SQLException {
		NormaGrupo normaGrupo = new NormaGrupo();
		normaGrupo.setCodigo(rs.getInt("nog_codigo"));
		normaGrupo.setNombre(rs.getString("nog_nombre"));
		normaGrupo.setCantidad(rs.getInt("nog_cantidad"));
		normaGrupo.setEstado(rs.getInt("nog_estado"));
		return normaGrupo;
	}
}
