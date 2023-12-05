package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IProgramaDao;
import com.usco.edu.entities.AreaConocimiento;
import com.usco.edu.entities.Nbc;
import com.usco.edu.entities.NivelFormacion;
import com.usco.edu.entities.Programa;
import com.usco.edu.service.IProgramaService;

@Service
public class ProgramaServiceImpl implements IProgramaService{
	
	@Autowired
	private IProgramaDao programaDao;
	
	@Override
	public List<Programa> obtenerListadoProgramas() {
		
		return programaDao.obtenerListadoProgramas();
		
	}
	
	@Override
	public List<NivelFormacion> obtenerListadoNivelesFormacion() {
		
		return programaDao.obtenerListadoNivelesFormacion();
		
	}

	@Override
	public List<NivelFormacion> obtenerListadoNivelFormacion(int nivelAcademicoCodigo) {
		
		return programaDao.obtenerListadoNivelFormacion(nivelAcademicoCodigo);
		
	}

	@Override
	public List<AreaConocimiento> obtenerListadoAreaConocimiento() {
		
		return programaDao.obtenerListadoAreaConocimiento();
		
	}

	@Override
	public List<Nbc> obtenerListadoNbc(int areaConocimientoCodigo) {
		
		return programaDao.obtenerListadoNbc(areaConocimientoCodigo);
		
	}

	@Override
	public int registrarPrograma(Programa programa) {
		
		System.out.println("Porgrama:: " + programa);

		return programaDao.registrarPrograma(programa);
		
	}

	@Override
	public int actualizarPrograma(Programa programa) {
		
		return programaDao.actualizarPrograma(programa);
		
	}
}
