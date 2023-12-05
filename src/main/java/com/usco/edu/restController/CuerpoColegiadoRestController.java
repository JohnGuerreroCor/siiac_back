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

import com.usco.edu.entities.CuerpoColegiado;
import com.usco.edu.entities.FuncionesCuerpoColegiado;
import com.usco.edu.entities.IntegranteCuerpoColegiado;
import com.usco.edu.service.ICuerpoColegiadoService;

@RestController
@RequestMapping(path = "cuerpocolegiado")
public class CuerpoColegiadoRestController {
	
	@Autowired
	ICuerpoColegiadoService cuerposColegiadosService;
	
	@GetMapping(path = "obtener-listado-cuerpos-colegiados")
	public List<CuerpoColegiado> obtenerListadoCuerposColegiados() {
		
		return cuerposColegiadosService.obtenerListadoCuerposColegiados();
		
	}
	
	@GetMapping(path = "obtener-cuerpos-colegiados-disponibilidad")
	public List<CuerpoColegiado> obtenerCuerpoColegiadoDisponibilidad() {
		
		return cuerposColegiadosService.obtenerCuerpoColegiadoDisponibilidad();
		
	}
	
	@GetMapping(path = "obtener-listado-funciones/{codigoCuerpoColegiado}")
	public List<FuncionesCuerpoColegiado> obtenerListadoFunciones(@PathVariable int codigoCuerpoColegiado) {
		
		return cuerposColegiadosService.obtenerListadoFunciones(codigoCuerpoColegiado);
		
	}
	
	@GetMapping(path = "obtener-listado-integrantes-cuerpo-colegiado")
	public List<IntegranteCuerpoColegiado> obtenerListadoIntegrantesCuerpoColegiado() {
		
		return cuerposColegiadosService.obtenerListadoIntegrantesCuerpoColegiado();
		
	}
	
	@GetMapping(path = "obtener-listado-integrantes/{codigoCuerpoColegiado}")
	public List<IntegranteCuerpoColegiado> obtenerListadoIntegrantesCuerpoColegiadoCodigo(@PathVariable int codigoCuerpoColegiado) {
		
		return cuerposColegiadosService.obtenerListadoIntegrantesCuerpoColegiadoCodigo(codigoCuerpoColegiado);
		
	}
	
	@PostMapping(path = "registrar-funciones-cuerpo-colegiado")
	public int registrarFuncion(@RequestBody FuncionesCuerpoColegiado funcion) {

		return cuerposColegiadosService.registrarFuncion(funcion);
		
	}
	
	@PutMapping(path = "actualizar-funciones-cuerpo-colegiado")
	public int actualizarFuncion(@RequestBody FuncionesCuerpoColegiado funcion) {
		
		return cuerposColegiadosService.actualizarFuncion(funcion);
		
	}
	
	@PostMapping(path = "registrar-cuerpos-colegiados")
	public int registrarCuerpoColegiado(@RequestBody CuerpoColegiado cuerposColegiados) {

		return cuerposColegiadosService.registrarCuerpoColegiado(cuerposColegiados);
		
	}
	
	@PutMapping(path = "actualizar-cuerpos-colegiados")
	public int actualizarCuerpoColegiado(@RequestBody CuerpoColegiado cuerposColegiados) {
		
		return cuerposColegiadosService.actualizarCuerpoColegiado(cuerposColegiados);
		
	}
	
	@PostMapping(path = "registrar-integrante")
	public int registrarIntegrante(@RequestBody IntegranteCuerpoColegiado integrante) {

		return cuerposColegiadosService.registrarIntegrante(integrante);
		
	}
	
	@PutMapping(path = "actualizar-integrante")
	public int actualizarIntegrante(@RequestBody IntegranteCuerpoColegiado integrante) {
		
		return cuerposColegiadosService.actualizarIntegrante(integrante);
		
	}

}
