package com.usco.edu.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CabecerasCentrosPoblados implements Serializable {

	private int codigo;

	private String nombre;
	
	private String divipola;

	private String tipo;
	
	private Municipio municipio;
	
	private static final long serialVersionUID = 1L;
	
}
