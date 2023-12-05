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

import com.usco.edu.entities.CineAmplio;
import com.usco.edu.entities.CineDetallado;
import com.usco.edu.entities.CineEspecifico;
import com.usco.edu.service.IClasificacionCineService;

@RestController
@RequestMapping(path = "cine")
public class ClasificacionCineRestController {
	
	@Autowired
	IClasificacionCineService clasificacionCineService;
	
	@GetMapping(path = "obtener-clasificacion-cine-amplio")
	public List<CineAmplio> obtenerListadoClasificacionCineAmplio() {
		
		return clasificacionCineService.obtenerListadoClasificacionCineAmplio();
		
	}
	
	@GetMapping(path = "obtener-clasificacion-cine-especifico")
	public List<CineEspecifico> obtenerListadoClasificacionCineEspecifico() {
		
		return clasificacionCineService.obtenerListadoClasificacionCineEspecifico();
		
	}
	
	@GetMapping(path = "obtener-clasificacion-cine-detallado")
	public List<CineDetallado> obtenerListadoClasificacionCineDetallado() {
		
		return clasificacionCineService.obtenerListadoClasificacionCineDetallado();
		
	}
	
	@GetMapping(path = "obtener-listado-cine-especifico-amplio/{cineAmplioCodigo}")
	public List<CineEspecifico> obtenerListadoEspecificoAmplio(@PathVariable int cineAmplioCodigo) {
		
		return clasificacionCineService.obtenerListadoEspecificoAmplio(cineAmplioCodigo);
		
	}
	
	@GetMapping(path = "obtener-listado-cine-detallado-especifico/{cineEspecificoCodigo}")
	public List<CineDetallado> obtenerListadoDetalladoEspecifico(@PathVariable int cineEspecificoCodigo) {
		
		return clasificacionCineService.obtenerListadoDetalladoEspecifico(cineEspecificoCodigo);
		
	}
	
	@GetMapping(path = "obtener-listado-cine/{codigo}")
	public List<CineDetallado> obtenerListadoCineDetallado(@PathVariable int codigo) {
		
		return clasificacionCineService.obtenerListadoCineDetallado(codigo);
		
	}
	
	@PostMapping(path = "registrar-cine-amplio")
	public int registrarCineAmplio(@RequestBody CineAmplio amplio) {

		return clasificacionCineService.registrarCineAmplio(amplio);
		
	}
	
	@PutMapping(path = "actualizar-cine-amplio")
	public int actualizarCineAmplio(@RequestBody CineAmplio amplio) {
		
		return clasificacionCineService.actualizarCineAmplio(amplio);
		
	}
	
	@PostMapping(path = "registrar-cine-especifico")
	public int registrarCineEspecifico(@RequestBody CineEspecifico especifico) {

		return clasificacionCineService.registrarCineEspecifico(especifico);
		
	}
	
	@PutMapping(path = "actualizar-cine-especifico")
	public int actualizarCineEspecifico(@RequestBody CineEspecifico especifico) {
		
		return clasificacionCineService.actualizarCineEspecifico(especifico);
		
	}
	
	
	@PostMapping(path = "registrar-cine-detallado")
	public int registrarCineDetallado(@RequestBody CineDetallado detallado) {

		return clasificacionCineService.registrarCineDetallado(detallado);
		
	}
	
	@PutMapping(path = "actualizar-cine-detallado")
	public int actualizarCineDetallado(@RequestBody CineDetallado detallado) {
		
		return clasificacionCineService.actualizarCineDetallado(detallado);
		
	}

}
