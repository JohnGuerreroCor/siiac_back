package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.IntegranteCuerpoColegiado;

public class IntegranteCuerpoColegiadoRowMapper implements RowMapper<IntegranteCuerpoColegiado>{

	@Override
	public IntegranteCuerpoColegiado mapRow(ResultSet rs, int rowNum) throws SQLException {
		IntegranteCuerpoColegiado integrante = new IntegranteCuerpoColegiado();
		integrante.setCodigo(rs.getInt("icc_codigo"));
		integrante.setCuerpoColegiado(new CuerpoColegiadoRowMapper().mapRow(rs, rowNum));
		integrante.setNombreCuerpoColegiado(rs.getString("cuc_nombre"));
		integrante.setPersonaCodigo(rs.getInt("per_codigo"));
		integrante.setPersonaIdentificacion(rs.getString("per_identificacion"));
		integrante.setPersonaNombre(rs.getString("per_nombre"));
		integrante.setPersonaApellido(rs.getString("per_apellido"));
		integrante.setCodigoNorma(rs.getInt("icc_norma"));
		integrante.setUsuarioTipo(new EstamentoRowMapper().mapRow(rs, rowNum));
		integrante.setMiembroTipo(new MiembroTipoRowMapper().mapRow(rs, rowNum));
		integrante.setFechaInicio(rs.getDate("icc_fecha_inicio"));
		integrante.setFechaFin(rs.getDate("icc_fecha_fin"));
		integrante.setObservacion(rs.getString("icc_observacicon"));
		integrante.setEstado(rs.getInt("icc_estado"));
		return integrante;
		
	}
	
}
