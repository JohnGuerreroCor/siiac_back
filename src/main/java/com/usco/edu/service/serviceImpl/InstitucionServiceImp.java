package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IInstitucionDao;
import com.usco.edu.entities.CaracterAcademico;
import com.usco.edu.entities.Institucion;
import com.usco.edu.entities.NaturalezaJuridica;
import com.usco.edu.entities.Sector;
import com.usco.edu.service.IInstitucionService;

@Service
public class InstitucionServiceImp implements IInstitucionService{
	
	@Autowired
	private IInstitucionDao institucionDao;

	@Override
	public List<CaracterAcademico> obtenerListadoCaracterAcademico() {
		
		return institucionDao.obtenerListadoCaracterAcademico();
		
	}

	@Override
	public List<NaturalezaJuridica> obtenerListadoNaturalezaJuridica() {
		return institucionDao.obtenerListadoNaturalezaJuridica();
	}

	@Override
	public List<Sector> obtenerListadoSector() {
		return institucionDao.obtenerListadoSector();
	}

	@Override
	public List<Institucion> obtenerListadoInstitucion() {
		return institucionDao.obtenerListadoInstitucion();
	}
	
	@Override
	public List<Institucion> obtenerInstitucion() {
		return institucionDao.obtenerInstitucion();
	}

	@Override
	public int registrar(Institucion institucion) {
		return institucionDao.registrar(institucion);
	}

	@Override
	public int actualizar(Institucion institucion) {
		return institucionDao.actualizar(institucion);
	}
	
}
