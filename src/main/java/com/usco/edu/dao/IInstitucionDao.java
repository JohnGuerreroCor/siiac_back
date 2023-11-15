package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.CaracterAcademico;
import com.usco.edu.entities.Institucion;
import com.usco.edu.entities.NaturalezaJuridica;
import com.usco.edu.entities.Sector;

public interface IInstitucionDao {
	
	public List<CaracterAcademico> obtenerListadoCaracterAcademico();
	
	public List<NaturalezaJuridica> obtenerListadoNaturalezaJuridica();
	
	public List<Sector> obtenerListadoSector();
	
	public List<Institucion> obtenerListadoInstitucion();
	
	public List<Institucion> obtenerInstitucion();
	
	public int registrar(Institucion institucion);
	
	int actualizar(Institucion institucion);

}
