package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.CabecerasCentrosPoblados;
import com.usco.edu.entities.Departamento;
import com.usco.edu.entities.Municipio;
import com.usco.edu.entities.Pais;

public interface IUbicacionDao {
	
	public List<Pais> obtenerPaisLocal();
	
	public List<Pais> obtenerPaises();
	
	public List<Departamento> obtenerDepartamentos();
	
	public List<Departamento> obtenerDepartamentosPorPais(int paiCodigo);
	
	public List<Municipio> obtenerMunicipios();
	
	public List<Municipio> obtenerMunicipiosPorDepartamento(String depCodigo);
	
	public List<CabecerasCentrosPoblados> obtenerCcp();
	
	public List<CabecerasCentrosPoblados> obtenerCcpPorMunicipio(String munCodigo);

}
