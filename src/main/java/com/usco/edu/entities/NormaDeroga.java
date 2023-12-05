package com.usco.edu.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NormaDeroga implements Serializable {

	private int codigo;
	private int derogaTipoCodigo;
	private String derogaTipo;
	private int normaPadreCodigo;
	private String normaPadre;
	private int normaHijoCodigo;
	private String normaHijo;
	private String observacion;
	private int estado;
	
	private static final long serialVersionUID = 1L;
}
