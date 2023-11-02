package com.usco.edu.entities;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Persona implements Serializable {

	private int codigo;
	
	private String identificacion;
	
	private TipoIdentificacion tipoId;
	
	private String libretaMilitar;

	private String nombre;

	private String apellido;
	
	private SexoBiologico sexoBiologico;
	
	private String lugarExpedicion;
	
	private Date fechaExpedicion;
	
	private Date fechaNacimiento;
	
	private String direccion;
	
	private String movil;
	
	private String fijo;
	
	private EstadoCivil estadoCivil;
	
	private String lugarNacimiento;
	
	private Estrato estrato;
	
	private int paisResidencia;
	
	private String departamentoResidencia;
	
	private String municipioResidencia;
	
	private String lugarResidencia;
	
	private String barrio;
	
	private int epsAfiliacion;
	
	private String sisben;
	
	private GrupoEtnico grupoEtnico;
	
	private PuebloIndigena puebloIndigena;
	
	private ComunidadNegra comunidadNegra;
	
	private PersonaDiscapacidad personaDiscapacidad;
	
	private DiscapacidadTipo discapacidadTipo;
	
	private TalentoExcepcional talentoExepcional;
	
	private String familiarDireccion;
	
	private String familiarNombre;
	
	private String familiarTelefono;
	
	private String familiarLugarResidencia;
	
	private String correo;
	
	private String correoInterno;
	
	private GrupoSanguineo grupoSanguineo;
	
	private int estado;
	
	private Date fechaRegistro;
	
	private static final long serialVersionUID = 1L;
}