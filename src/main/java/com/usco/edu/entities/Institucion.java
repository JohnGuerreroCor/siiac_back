package com.usco.edu.entities;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Institucion implements Serializable {
	
	private int codigo;
	private String nit;
	private int ies;
	private int iesPadre;
	private NaturalezaJuridica naturaleza;
	private Sector sector;
	private CaracterAcademico caracter;
	private String nombre;
	private Pais pais;
	private Departamento departamento;
	private Municipio municipio;
	private CabecerasCentrosPoblados ccp;
	private String direccion;
	private String telefono;
	private String url;
	private int normaCodigo;
	private String norma;
	private Date fechaNorma;
	private int estado;
	
	private static final long serialVersionUID = 1L;

}