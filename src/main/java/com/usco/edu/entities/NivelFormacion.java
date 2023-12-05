package com.usco.edu.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NivelFormacion implements Serializable {
	
	private int codigo;
	private int nivelAcademicoCodigo;
	private String nivelAcademico;
	private String nombre;
	private int estado;
	
	private static final long serialVersionUID = 1L;
}
