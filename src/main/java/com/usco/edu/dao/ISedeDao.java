package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.SedeGeneral;
import com.usco.edu.entities.SedeTipo;

public interface ISedeDao {
	
	public List<SedeTipo> obtenerListadoTiposSedes();
	
	public List<SedeGeneral> obtenerListadoSedes();
	
	public int registrar(SedeGeneral sede);
	
	public int actualizar(SedeGeneral sede);

}
