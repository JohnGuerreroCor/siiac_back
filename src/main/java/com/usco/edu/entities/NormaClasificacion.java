package com.usco.edu.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NormaClasificacion implements Serializable {

	private int codigo;
	private Norma norma;
	private String nombreCompleto;
	private String entidad;
	private String normaTipo;
	private NormaGrupo normaGrupo;
	private int estado;
	
	private static final long serialVersionUID = 1L;
	
}
