package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.CineAmplio;
import com.usco.edu.entities.CineDetallado;
import com.usco.edu.entities.CineEspecifico;

public interface IClasificacionCineDao {
	
	public List<CineAmplio> obtenerListadoClasificacionCineAmplio();
	
	public List<CineEspecifico> obtenerListadoClasificacionCineEspecifico();
	
	public List<CineDetallado> obtenerListadoClasificacionCineDetallado();
	
	public List<CineEspecifico> obtenerListadoEspecificoAmplio(int cineAmplioCodigo);
	
	public List<CineDetallado> obtenerListadoDetalladoEspecifico(int cineEspecificoCodigo);
	
	public List<CineDetallado> obtenerListadoCineDetallado(int codigo);
	
	public int registrarCineAmplio(CineAmplio amplio);
	
	public int actualizarCineAmplio(CineAmplio amplio);
	
	public int registrarCineEspecifico(CineEspecifico especifico);
	
	public int actualizarCineEspecifico(CineEspecifico especifico);
	
	public int registrarCineDetallado(CineDetallado detallado);
	
	public int actualizarCineDetallado(CineDetallado detallado);

}
