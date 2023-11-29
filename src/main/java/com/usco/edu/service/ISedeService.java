package com.usco.edu.service;

import java.util.List;

import com.usco.edu.entities.SedeGeneral;
import com.usco.edu.entities.SedeTipo;

public interface ISedeService {
	
	public List<SedeTipo> obtenerListadoTiposSedes();
	
	public List<SedeGeneral> obtenerListadoSedes();
	
	public int registrar(SedeGeneral sede);
	
	int actualizar(SedeGeneral sede);

}
