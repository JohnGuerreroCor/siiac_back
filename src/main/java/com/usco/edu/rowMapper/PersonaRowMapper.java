package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.Persona;

public class PersonaRowMapper implements RowMapper<Persona>{

	@Override
	public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
		Persona persona = new Persona();
		persona.setCodigo(rs.getInt("per_codigo"));
        persona.setIdentificacion(rs.getString("per_identificacion"));
        persona.setTipoId(new TipoIdentificacionRowMapper().mapRow(rs, rowNum));
        persona.setLibretaMilitar(rs.getString("per_libreta_militar"));
        persona.setNombre(rs.getString("per_nombre"));
        persona.setApellido(rs.getString("per_apellido"));
        persona.setSexoBiologico(new SexoBiologicoRowMapper().mapRow(rs, rowNum));
        persona.setLugarExpedicion(rs.getString("per_lugar_expedicion"));
        persona.setFechaExpedicion(rs.getDate("per_fecha_expedicion"));
        persona.setFechaNacimiento(rs.getDate("per_fecha_nacimiento"));
        persona.setDireccion(rs.getString("per_direccion_residencia"));
        persona.setMovil(rs.getString("per_telefono_movil"));
        persona.setFijo(rs.getString("per_telefono_fijo"));
        persona.setEstadoCivil(new EstadoCivilRowMapper().mapRow(rs, rowNum));
        persona.setLugarNacimiento(rs.getString("per_lugar_nacimiento"));
        persona.setEstrato(new EstratoRowMapper().mapRow(rs, rowNum));
        persona.setPaisResidencia(rs.getInt("per_pais_residencia"));
        persona.setDepartamentoResidencia(rs.getString("per_departamento_residencia"));
        persona.setMunicipioResidencia(rs.getString("per_municipio_residencia"));
        persona.setLugarResidencia(rs.getString("per_lugar_residencia"));
        persona.setBarrio(rs.getString("per_barrio"));
        persona.setEpsAfiliacion(rs.getInt("per_numero_afiliacion_eps"));
        persona.setSisben(rs.getString("per_ips_sisben"));
        persona.setGrupoEtnico(new GrupoEtnicoRowMapper().mapRow(rs, rowNum));
        persona.setPuebloIndigena(new PuebloIndigenaRowMapper().mapRow(rs, rowNum));
        persona.setComunidadNegra(new ComunidadNegraRowMapper().mapRow(rs, rowNum));
        persona.setPersonaDiscapacidad(new PersonaDiscapacidadRowMapper().mapRow(rs, rowNum));
        persona.setDiscapacidadTipo(new DiscapacidadTipoRowMapper().mapRow(rs, rowNum));
        persona.setTalentoExepcional(new TalentoExcepcionalRowMapper().mapRow(rs, rowNum));
        persona.setFamiliarDireccion(rs.getString("per_familiar_direccion"));
        persona.setFamiliarNombre(rs.getString("per_familiar_nombre"));
        persona.setFamiliarTelefono(rs.getString("per_familiar_telefono"));
        persona.setFamiliarLugarResidencia(rs.getString("per_familiar_lugar_residencia"));
        persona.setCorreo(rs.getString("per_email"));
        persona.setCorreoInterno(rs.getString("per_email_interno"));
        persona.setGrupoSanguineo(new GrupoSanguineoRowMapper().mapRow(rs, rowNum));
        persona.setEstado(rs.getInt("per_estado"));
        persona.setFechaRegistro(rs.getDate("per_fecha_registro"));
		return persona;
	}

}