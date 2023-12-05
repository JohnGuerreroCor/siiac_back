package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IFacultadDao;
import com.usco.edu.entities.Facultad;
import com.usco.edu.service.IFacultadService;

@Service
public class FacultadServiceImpl implements IFacultadService{
	
	@Autowired
	private IFacultadDao facultadDao;

	@Override
	public List<Facultad> obtenerListadoFacultades() {
		
		return facultadDao.obtenerListadoFacultades();
		
	}
	
	@Override
	public List<Facultad> obtenerListadoFacultadSede(int sedeCodigo) {
		
		return facultadDao.obtenerListadoFacultadSede(sedeCodigo);
		
	}

	@Override
	public int registrar(Facultad facultad) {
		
		return facultadDao.registrar(facultad);
		
	}

	@Override
	public int actualizar(Facultad facultad) {
		
		return facultadDao.actualizar(facultad);
		
	}

}
