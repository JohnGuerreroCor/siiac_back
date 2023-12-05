package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.Facultad;
import com.usco.edu.service.IFacultadService;

@RestController
@RequestMapping(path = "facultad")
public class FacultadRestController {
	
	@Autowired
	IFacultadService facultadService;
	
	@GetMapping(path = "obtener-listado-facultades")
	public List<Facultad> obtenerListadoFacultades() {
		
		return facultadService.obtenerListadoFacultades();
		
	}
	
	@GetMapping(path = "obtener-listado-facultad-sede/{sedeCodigo}")
	public List<Facultad> obtenerListadoFacultadSede(@PathVariable int sedeCodigo) {
		
		return facultadService.obtenerListadoFacultadSede(sedeCodigo);
		
	}
	
	@PostMapping(path = "registrar-facultad")
	public int registrar(@RequestBody Facultad facultad) {

		return facultadService.registrar(facultad);
		
	}
	
	@PutMapping(path = "actualizar-facultad")
	public int actualizar(@RequestBody Facultad facultad) {
		
		return facultadService.actualizar(facultad);
		
	}

}
