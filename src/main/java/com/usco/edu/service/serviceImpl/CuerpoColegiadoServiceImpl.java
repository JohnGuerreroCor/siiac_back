package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.ICuerpoColegiadoDao;
import com.usco.edu.entities.CuerpoColegiado;
import com.usco.edu.entities.FuncionesCuerpoColegiado;
import com.usco.edu.entities.IntegranteCuerpoColegiado;
import com.usco.edu.service.ICuerpoColegiadoService;

@Service
public class CuerpoColegiadoServiceImpl implements ICuerpoColegiadoService{
	
	@Autowired
	private ICuerpoColegiadoDao cuerposColegiadosDao;

	@Override
	public List<CuerpoColegiado> obtenerListadoCuerposColegiados() {
		
		return cuerposColegiadosDao.obtenerListadoCuerposColegiados();
		
	}
	
	@Override
	public List<CuerpoColegiado> obtenerCuerpoColegiadoDisponibilidad() {
		
		return cuerposColegiadosDao.obtenerCuerpoColegiadoDisponibilidad();
		
	}
	
	@Override
	public List<FuncionesCuerpoColegiado> obtenerListadoFunciones(int codigoCuerpoColegiado) {
		
		return cuerposColegiadosDao.obtenerListadoFunciones(codigoCuerpoColegiado);
		
	}
	
	@Override
	public List<IntegranteCuerpoColegiado> obtenerListadoIntegrantesCuerpoColegiado() {
		
		return cuerposColegiadosDao.obtenerListadoIntegrantesCuerpoColegiado();
		
	}

	@Override
	public List<IntegranteCuerpoColegiado> obtenerListadoIntegrantesCuerpoColegiadoCodigo(int codigoCuerpoColegiado) {
		
		return cuerposColegiadosDao.obtenerListadoIntegrantesCuerpoColegiadoCodigo(codigoCuerpoColegiado);
		
	}

	@Override
	public int registrarCuerpoColegiado(CuerpoColegiado cuerposColegiados) {
		
		return cuerposColegiadosDao.registrarCuerpoColegiado(cuerposColegiados);
		
	}

	@Override
	public int actualizarCuerpoColegiado(CuerpoColegiado cuerposColegiados) {
		
		return cuerposColegiadosDao.actualizarCuerpoColegiado(cuerposColegiados);
		
	}

	@Override
	public int registrarFuncion(FuncionesCuerpoColegiado funcion) {
		
		return cuerposColegiadosDao.registrarFuncion(funcion);
		
	}

	@Override
	public int actualizarFuncion(FuncionesCuerpoColegiado funcion) {
		
		return cuerposColegiadosDao.actualizarFuncion(funcion);
		
	}

	@Override
	public int registrarIntegrante(IntegranteCuerpoColegiado integrante) {
		
		return cuerposColegiadosDao.registrarIntegrante(integrante);
		
	}

	@Override
	public int actualizarIntegrante(IntegranteCuerpoColegiado integrante) {
		
		return cuerposColegiadosDao.actualizarIntegrante(integrante);
		
	}

}
