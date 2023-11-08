package com.usco.edu.service;

import java.util.List;

import com.usco.edu.entities.CabecerasCentrosPoblados;
import com.usco.edu.entities.Departamento;
import com.usco.edu.entities.Municipio;
import com.usco.edu.entities.Pais;

public interface IUbicacionService {
	
	public List<Pais> obtenerPaisLocal();
	
	public List<Pais> obtenerPaises();
	
	public List<Departamento> obtenerDepartamentos();
	
	public List<Municipio> obtenerMunicipios();
	
	public List<CabecerasCentrosPoblados> obtenerCcp();
	
	public List<Departamento> obtenerDepartamentosPorPais(int paiCodigo);
	
	public List<Municipio> obtenerMunicipiosPorDepartamento(String depCodigo);
	
	public List<CabecerasCentrosPoblados> obtenerCcpPorMunicipio(String munCodigo);

}
