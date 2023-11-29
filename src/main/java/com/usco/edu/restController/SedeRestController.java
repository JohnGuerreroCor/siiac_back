package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.SedeGeneral;
import com.usco.edu.entities.SedeTipo;
import com.usco.edu.service.ISedeService;

@RestController
@RequestMapping(path = "sede")
public class SedeRestController {
	
	@Autowired
	ISedeService sedeService;
	
	@GetMapping(path = "obtener-listado-tipo-sedes")
	public List<SedeTipo> obtenerListadoTiposSedes() {
		
		return sedeService.obtenerListadoTiposSedes();
		
	}
	
	@GetMapping(path = "obtener-listado-sedes")
	public List<SedeGeneral> obtenerListadoSedes() {
		
		return sedeService.obtenerListadoSedes();
		
	}
	
	@PostMapping(path = "registrar-sede")
	public int registrar(@RequestBody SedeGeneral sede) {

		return sedeService.registrar(sede);
		
	}
	
	@PutMapping(path = "actualizar-sede")
	public int actualizar(@RequestBody SedeGeneral sede) {
		
		return sedeService.actualizar(sede);
		
	}

}
