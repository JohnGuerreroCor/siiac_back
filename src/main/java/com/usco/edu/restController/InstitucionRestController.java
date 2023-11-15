package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.CaracterAcademico;
import com.usco.edu.entities.Institucion;
import com.usco.edu.entities.NaturalezaJuridica;
import com.usco.edu.entities.Sector;
import com.usco.edu.service.IInstitucionService;

@RestController
@RequestMapping(path = "institucion")
public class InstitucionRestController {
	
	@Autowired
	IInstitucionService institucionService;
	
	@GetMapping(path = "obtener-listado-caracter-academico")
	public List<CaracterAcademico> obtenerListadoCaracterAcademico() {
		
		return institucionService.obtenerListadoCaracterAcademico();
		
	}
	
	@GetMapping(path = "obtener-listado-naturaleza-juridica")
	public List<NaturalezaJuridica> obtenerListadoNaturalezaJuridica() {
		
		return institucionService.obtenerListadoNaturalezaJuridica();
		
	}
	
	@GetMapping(path = "obtener-listado-sector")
	public List<Sector> obtenerListadoSector() {
		
		return institucionService.obtenerListadoSector();
		
	}
	
	@GetMapping(path = "obtener-listado-institucion")
	public List<Institucion> obtenerListadoInstitucion() {
		
		return institucionService.obtenerListadoInstitucion();
		
	}
	
	@GetMapping(path = "obtener-institucion")
	public List<Institucion> obtenerInstitucion() {
		
		return institucionService.obtenerInstitucion();
		
	}
	
	@PostMapping(path = "registrar-institucion")
	public int registrar(@RequestBody Institucion institucion) {

		return institucionService.registrar(institucion);
		
	}
	
	@PutMapping(path = "actualizar-institucion")
	public int actualizar(@RequestBody Institucion institucion) {
		
		return institucionService.actualizar(institucion);
		
	}

}
