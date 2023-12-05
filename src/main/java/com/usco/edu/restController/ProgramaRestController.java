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

import com.usco.edu.entities.AreaConocimiento;
import com.usco.edu.entities.Nbc;
import com.usco.edu.entities.NivelFormacion;
import com.usco.edu.entities.Programa;
import com.usco.edu.service.IProgramaService;

@RestController
@RequestMapping(path = "programa")
public class ProgramaRestController {
	
	@Autowired
	IProgramaService programaService;
	
	@GetMapping(path = "obtener-listado-programas")
	public List<Programa> obtenerListadoProgramas() {
		
		return programaService.obtenerListadoProgramas();
		
	}
	
	@GetMapping(path = "obtener-listado-niveles-formacion")
	public List<NivelFormacion> obtenerListadoNivelesFormacion() {
		
		return programaService.obtenerListadoNivelesFormacion();
		
	}
	
	@GetMapping(path = "obtener-listado-nivel-formacion/{nivelAcademicoCodigo}")
	public List<NivelFormacion> obtenerListadoNivelFormacion(@PathVariable int nivelAcademicoCodigo) {
		
		return programaService.obtenerListadoNivelFormacion(nivelAcademicoCodigo);
		
	}
	
	@GetMapping(path = "obtener-listado-area-conocimiento")
	public List<AreaConocimiento> obtenerListadoAreaConocimiento() {
		
		return programaService.obtenerListadoAreaConocimiento();
		
	}
	
	@GetMapping(path = "obtener-listado-nbc/{areaConocimientoCodigo}")
	public List<Nbc> obtenerListadoNbc(@PathVariable int areaConocimientoCodigo) {
		
		return programaService.obtenerListadoNbc(areaConocimientoCodigo);
		
	}
	
	@PostMapping(path = "registrar-programa")
	public int registrar(@RequestBody Programa programa) {

		return programaService.registrarPrograma(programa);
		
	}
	
	@PutMapping(path = "actualizar-programa")
	public int actualizar(@RequestBody Programa programa) {
		
		return programaService.actualizarPrograma(programa);
		
	}

}
