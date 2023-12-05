package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.NormaDeroga;

public class NormaDerogaRowMapper implements RowMapper<NormaDeroga>{

	@Override
	public NormaDeroga mapRow(ResultSet rs, int rowNum) throws SQLException {
		NormaDeroga normaDeroga = new NormaDeroga();
		normaDeroga.setCodigo(rs.getInt("nod_codigo"));
		normaDeroga.setDerogaTipoCodigo(rs.getInt("det_codigo"));
		normaDeroga.setDerogaTipo(rs.getString("det_nombre"));
		normaDeroga.setNormaPadreCodigo(rs.getInt("nor_codigo_padre"));
		normaDeroga.setNormaPadre(rs.getString("nor_nombre_padre"));
		normaDeroga.setNormaHijoCodigo(rs.getInt("nor_codigo_hijo"));
		normaDeroga.setNormaHijo(rs.getString("nor_nombre_hijo"));
		normaDeroga.setObservacion(rs.getString("nod_observacion"));
		normaDeroga.setEstado(rs.getInt("nod_estado"));
		return normaDeroga;
	}
}
