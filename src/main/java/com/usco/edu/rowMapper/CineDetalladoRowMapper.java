package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.CineDetallado;

public class CineDetalladoRowMapper implements RowMapper<CineDetallado>{

	@Override
	public CineDetallado mapRow(ResultSet rs, int rowNum) throws SQLException {
		CineDetallado detallado = new CineDetallado();
		detallado.setCodigo(rs.getInt("cdc_codigo"));
		detallado.setNombre(rs.getString("cdc_nombre"));
		detallado.setCine(rs.getString("cdc_cine"));
		detallado.setAmplioCodigo(rs.getInt("cac_codigo"));
		detallado.setAmplioCine(rs.getString("cac_cine"));
		detallado.setAmplio(rs.getString("cac_nombre"));
		detallado.setEspecificoCodigo(rs.getInt("cec_codigo"));
		detallado.setEspecificoCine(rs.getString("cec_cine"));
		detallado.setEspecifico(rs.getString("cec_nombre"));
		detallado.setEstado(rs.getInt("cdc_estado"));
		return detallado;
	}
}
