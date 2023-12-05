package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.AreaConocimiento;
import com.usco.edu.entities.Nbc;
import com.usco.edu.entities.NivelFormacion;
import com.usco.edu.entities.Programa;

public interface IProgramaDao {
	
	public List<Programa> obtenerListadoProgramas();
	
	public List<NivelFormacion> obtenerListadoNivelesFormacion();
	
	public List<NivelFormacion> obtenerListadoNivelFormacion(int nivelAcademicoCodigo);
	
	public List<AreaConocimiento> obtenerListadoAreaConocimiento();
	
	public List<Nbc> obtenerListadoNbc(int areaConocimientoCodigo);
	
	public int registrarPrograma(Programa programa);
	
	public int actualizarPrograma(Programa programa);

}
