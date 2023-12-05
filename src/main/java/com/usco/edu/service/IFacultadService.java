package com.usco.edu.service;

import java.util.List;

import com.usco.edu.entities.Facultad;

public interface IFacultadService {
	
	public List<Facultad> obtenerListadoFacultades();
	
	public List<Facultad> obtenerListadoFacultadSede(int sedeCodigo);
	
	public int registrar(Facultad facultad);
	
	public int actualizar(Facultad facultad);

}
