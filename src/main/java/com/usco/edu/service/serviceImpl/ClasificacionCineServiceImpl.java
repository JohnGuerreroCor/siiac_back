package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IClasificacionCineDao;
import com.usco.edu.entities.CineAmplio;
import com.usco.edu.entities.CineDetallado;
import com.usco.edu.entities.CineEspecifico;
import com.usco.edu.service.IClasificacionCineService;

@Service
public class ClasificacionCineServiceImpl implements IClasificacionCineService{
	
	@Autowired
	private IClasificacionCineDao clasificacionCineDao;

	@Override
	public List<CineAmplio> obtenerListadoClasificacionCineAmplio() {
		
		return clasificacionCineDao.obtenerListadoClasificacionCineAmplio();
		
	}

	@Override
	public List<CineEspecifico> obtenerListadoClasificacionCineEspecifico() {
		
		return clasificacionCineDao.obtenerListadoClasificacionCineEspecifico();
		
	}

	@Override
	public List<CineDetallado> obtenerListadoClasificacionCineDetallado() {
		
		return clasificacionCineDao.obtenerListadoClasificacionCineDetallado();
		
	}
	
	@Override
	public List<CineEspecifico> obtenerListadoEspecificoAmplio(int cineAmplioCodigo) {
		
		return clasificacionCineDao.obtenerListadoEspecificoAmplio(cineAmplioCodigo);
		
	}
	
	@Override
	public List<CineDetallado> obtenerListadoDetalladoEspecifico(int cineEspecificoCodigo) {
		
		return clasificacionCineDao.obtenerListadoDetalladoEspecifico(cineEspecificoCodigo);
		
	}

	@Override
	public List<CineDetallado> obtenerListadoCineDetallado(int codigo) {
		
		return clasificacionCineDao.obtenerListadoCineDetallado(codigo);
		
	}

	@Override
	public int registrarCineAmplio(CineAmplio amplio) {
		
		return clasificacionCineDao.registrarCineAmplio(amplio);
		
	}

	@Override
	public int actualizarCineAmplio(CineAmplio amplio) {
		
		return clasificacionCineDao.actualizarCineAmplio(amplio);
		
	}

	@Override
	public int registrarCineEspecifico(CineEspecifico especifico) {
		
		return clasificacionCineDao.registrarCineEspecifico(especifico);
		
	}

	@Override
	public int actualizarCineEspecifico(CineEspecifico especifico) {
		
		return clasificacionCineDao.actualizarCineEspecifico(especifico);
		
	}

	@Override
	public int registrarCineDetallado(CineDetallado detallado) {
		
		return clasificacionCineDao.registrarCineDetallado(detallado);
		
	}

	@Override
	public int actualizarCineDetallado(CineDetallado detallado) {
		
		return clasificacionCineDao.actualizarCineDetallado(detallado);
		
	}
	
}
