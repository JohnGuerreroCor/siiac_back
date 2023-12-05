package com.usco.edu.entities;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CuerpoColegiado implements Serializable {

	private int codigo;

	private String nombre;
	
	private String nombreCorto;
	
	private int numeroNorma;
	
	private String nombreNorma;
	
	private Date fechaNorma;
	
	private Date fechaCreacion;
	
	private int cantidadMiembros;
	
	private int disponibilidadMiembros;
	
	private int estado;
	
	private static final long serialVersionUID = 1L;
}
