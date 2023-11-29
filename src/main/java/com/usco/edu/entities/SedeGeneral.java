package com.usco.edu.entities;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SedeGeneral implements Serializable {
	
	private int codigo;
	private String nit;
	private String nombre;
	private Pais pais;
	private Departamento departamento;
	private Municipio municipio;
	private CabecerasCentrosPoblados ccp;
	private String direccion;
	private String telefono;
	private SedeTipo sedeTipo;
	private Date fechaCreacion;
	private int estado;
	
	private static final long serialVersionUID = 1L;

}