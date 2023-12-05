package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.Norma;

public class NormaRowMapper implements RowMapper<Norma>{

	@Override
	public Norma mapRow(ResultSet rs, int rowNum) throws SQLException {
		Norma norma = new Norma();
		norma.setCodigo(rs.getInt("nor_codigo"));
		norma.setEntidadCodigo(rs.getInt("noe_codigo"));
		norma.setEntidad(rs.getString("noe_nombre"));
		norma.setEntidadExternaCodigo(rs.getInt("ene_codigo"));
		norma.setEntidadExterna(rs.getString("ene_nombre"));
		norma.setRectoria(rs.getInt("nor_rectoria"));
		norma.setCuerpoColegiadoCodigo(rs.getInt("cuc_codigo"));
		norma.setCuerpoColegiado(rs.getString("cuc_nombre"));
		norma.setNormaTipoCodigo(rs.getInt("not_codigo"));
		norma.setNormaTipo(rs.getString("not_nombre"));
		norma.setNumero(rs.getString("nor_numero"));
		norma.setNombre(rs.getString("nor_nombre"));
		norma.setNombreCompleto(rs.getString("not_nombre")+" "+rs.getString("nor_numero")+" "+rs.getString("nor_nombre"));
		norma.setUrl(rs.getString("nor_url"));
		norma.setMedioCodigo(rs.getInt("nom_codigo"));
		norma.setMedio(rs.getString("nom_nombre"));
		norma.setFechaExpedicion(rs.getDate("nor_fecha_expedicion"));
		norma.setFechaVigencia(rs.getDate("nor_fecha_vigencia"));
		norma.setDeroga(rs.getInt("nor_deroga"));
		norma.setDerogaTipoCodigo(rs.getInt("det_codigo"));
		norma.setDerogaPadre(rs.getString("deroga_padre"));
		norma.setObservacion(rs.getString("nor_observacion"));
		norma.setEstado(rs.getInt("nor_estado"));
		return norma;
	}
}
