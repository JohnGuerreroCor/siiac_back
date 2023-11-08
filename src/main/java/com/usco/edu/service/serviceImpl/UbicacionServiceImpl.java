package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IUbicacionDao;
import com.usco.edu.service.IUbicacionService;
import com.usco.edu.entities.CabecerasCentrosPoblados;
import com.usco.edu.entities.Departamento;
import com.usco.edu.entities.Municipio;
import com.usco.edu.entities.Pais;

@Service
public class UbicacionServiceImpl implements IUbicacionService{
	
	@Autowired
	private IUbicacionDao ubicacionDao;

	@Override
	public List<Pais> obtenerPaisLocal() {
		
		return ubicacionDao.obtenerPaisLocal();
		
	}

	@Override
	public List<Pais> obtenerPaises() {
		
		return ubicacionDao.obtenerPaises();
		
	}

	@Override
	public List<Departamento> obtenerDepartamentosPorPais(int paiCodigo) {
		
		return ubicacionDao.obtenerDepartamentosPorPais(paiCodigo);
		
	}

	@Override
	public List<Municipio> obtenerMunicipiosPorDepartamento(String depCodigo) {
		
		return ubicacionDao.obtenerMunicipiosPorDepartamento(depCodigo);
		
	}

	@Override
	public List<CabecerasCentrosPoblados> obtenerCcpPorMunicipio(String munCodigo) {
		
		return ubicacionDao.obtenerCcpPorMunicipio(munCodigo);
		
	}

	@Override
	public List<Departamento> obtenerDepartamentos() {
		
		return ubicacionDao.obtenerDepartamentos();
		
	}

	@Override
	public List<Municipio> obtenerMunicipios() {
		return ubicacionDao.obtenerMunicipios();
	}

	@Override
	public List<CabecerasCentrosPoblados> obtenerCcp() {
		return ubicacionDao.obtenerCcp();
	}

}
