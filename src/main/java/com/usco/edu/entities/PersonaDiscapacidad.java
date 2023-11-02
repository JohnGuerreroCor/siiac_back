package com.usco.edu.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonaDiscapacidad implements Serializable {

	private int codigo;

	private String condicion;
	
	private int estado;
	
	private static final long serialVersionUID = 1L;

}