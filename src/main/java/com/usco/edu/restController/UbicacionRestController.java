package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.service.IUbicacionService;
import com.usco.edu.entities.CabecerasCentrosPoblados;
import com.usco.edu.entities.Departamento;
import com.usco.edu.entities.Municipio;
import com.usco.edu.entities.Pais;

@RestController
@RequestMapping(path = "ubicacion")
public class UbicacionRestController {
	
	@Autowired
	IUbicacionService ubicacionService;
	
	@GetMapping(path = "obtener-pais-local")
	public List<Pais> obtenerPaisLocal() {
		
		return ubicacionService.obtenerPaisLocal();
		
	}
	
	@GetMapping(path = "obtener-paises")
	public List<Pais> obtenerPaises() {
		
		return ubicacionService.obtenerPaises();
		
	}
	
	@GetMapping(path = "obtener-departamentos-por-pais/{paiCodigo}")
	public List<Departamento> obtenerDepartamentosPorPais(@PathVariable int paiCodigo) {
		
		return ubicacionService.obtenerDepartamentosPorPais(paiCodigo);
		
	}
	
	@GetMapping(path = "obtener-municipios-por-departamento/{depCodigo}")
	public List<Municipio> obtenerDepartamentosPorPais(@PathVariable String depCodigo) {
		
		return ubicacionService.obtenerMunicipiosPorDepartamento(depCodigo);
		
	}
	
	@GetMapping(path = "obtener-ccp-por-municipio/{munCodigo}")
	public List<CabecerasCentrosPoblados> obtenerCcpPorMunicipio(@PathVariable String munCodigo) {
		
		return ubicacionService.obtenerCcpPorMunicipio(munCodigo);
		
	}
	
	@GetMapping(path = "obtener-departamentos")
	public List<Departamento> obtenerDepartamentos() {
		
		return ubicacionService.obtenerDepartamentos();
		
	}
	
	
	@GetMapping(path = "obtener-municipios")
	public List<Municipio> obtenerMunicipios() {
		
		return ubicacionService.obtenerMunicipios();
		
	}
	
	
	@GetMapping(path = "obtener-ccp")
	public List<CabecerasCentrosPoblados> obtenerCcp() {
		
		return ubicacionService.obtenerCcp();
		
	}

}
