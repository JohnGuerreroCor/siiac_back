package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.ISedeDao;
import com.usco.edu.entities.SedeGeneral;
import com.usco.edu.entities.SedeTipo;
import com.usco.edu.service.ISedeService;

@Service
public class SedeServiceImpl implements ISedeService{
	
	@Autowired
	private ISedeDao sedeDao;

	@Override
	public List<SedeTipo> obtenerListadoTiposSedes() {

		return sedeDao.obtenerListadoTiposSedes();
	}

	@Override
	public List<SedeGeneral> obtenerListadoSedes() {
		
		return sedeDao.obtenerListadoSedes();
		
	}

	@Override
	public int registrar(SedeGeneral sede) {

		return sedeDao.registrar(sede);
		
	}

	@Override
	public int actualizar(SedeGeneral sede) {
		
		return sedeDao.actualizar(sede);
		
	}
}
