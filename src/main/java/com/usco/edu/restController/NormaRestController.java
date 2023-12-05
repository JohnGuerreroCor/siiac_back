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

import com.usco.edu.entities.EntidadExterna;
import com.usco.edu.entities.Norma;
import com.usco.edu.entities.NormaClasificacion;
import com.usco.edu.entities.NormaDeroga;
import com.usco.edu.entities.NormaGrupo;
import com.usco.edu.entities.NormaTipo;
import com.usco.edu.service.INormaService;

@RestController
@RequestMapping(path = "norma")
public class NormaRestController {
	
	@Autowired
	INormaService normaService;
	
	@GetMapping(path = "obtener-normas")
	public List<Norma> obtenerNormas() {
		
		return normaService.obtenerNormas();
		
	}
	
	@GetMapping(path = "obtener-norma/{normaCodigo}")
	public List<Norma> obtenerNorma(@PathVariable int normaCodigo) {
		
		return normaService.obtenerNorma(normaCodigo);
		
	}
	
	@GetMapping(path = "obtener-normas-no-derogadas")
	public List<Norma> obtenerNormasNoDerogadas() {
		
		return normaService.obtenerNormasNoDerogadas();
		
	}
	
	@GetMapping(path = "obtener-entidades-externas")
	public List<EntidadExterna> obtenerEntidadesExternas() {
		
		return normaService.obtenerEntidadesExternas();
		
	}
	
	@GetMapping(path = "obtener-normas-tipo/{entidadCodigo}")
	public List<NormaTipo> obtenerNormasTipo(@PathVariable int entidadCodigo) {
		
		return normaService.obtenerNormasTipo(entidadCodigo);
		
	}
	
	@PostMapping(path = "registrar-norma")
	public int registrarNorma(@RequestBody Norma norma) {

		return normaService.registrarNorma(norma);
		
	}
	
	@PutMapping(path = "actualizar-norma")
	public int actualizarNorma(@RequestBody Norma norma) {
		
		return normaService.actualizarNorma(norma);
		
	}
	
	@PutMapping(path = "suspender-norma")
	public int suspenderNorma(@RequestBody Norma norma) {
		
		return normaService.suspenderNorma(norma);
		
	}
	
///////////////////DEROGA
	
	@GetMapping(path = "obtener-normas-derogadas/{norma}")
	public List<NormaDeroga> obtenerNormaDerogada(@PathVariable int norma) {
		
		return normaService.obtenerNormaDerogada(norma);
		
	}
	
	@PostMapping(path = "registrar-norma-deroga")
	public int registrarNormaDeroga(@RequestBody NormaDeroga deroga) {

		return normaService.registrarNormaDeroga(deroga);
		
	}
	
	@PutMapping(path = "actualizar-norma-deroga")
	public int actualizarNormaDeroga(@RequestBody NormaDeroga deroga) {
		
		return normaService.actualizarNormaDeroga(deroga);
		
	}
	
	
/////CLASIFICACION
	
	@GetMapping(path = "obtener-norma-grupos")
	public List<NormaGrupo> obtenerNormaGrupos() {
		
		return normaService.obtenerNormaGrupos();
		
	}
	
	@GetMapping(path = "obtener-norma-grupos-agrupado")
	public List<NormaGrupo> obtenerNormaGruposAgrupados() {
		
		return normaService.obtenerNormaGruposAgrupados();
		
	}
	
	@GetMapping(path = "obtener-normas-sin-clasificar/{normaGrupoCodigo}")
	public List<Norma> obtenerNormaSinClasificar(@PathVariable int normaGrupoCodigo) {
		
		return normaService.obtenerNormaSinClasificar(normaGrupoCodigo);
		
	}
	
	@GetMapping(path = "obtener-normas-clasificadas/{normaGrupoCodigo}")
	public List<NormaClasificacion> obtenerNormaClasificada(@PathVariable int normaGrupoCodigo) {
		
		return normaService.obtenerNormaClasificada(normaGrupoCodigo);
		
	}
	
	@PostMapping(path = "registrar-norma-clasificada")
	public int registrarNormaClasificada(@RequestBody NormaClasificacion normaClasificacion) {

		return normaService.registrarNormaClasificada(normaClasificacion);
		
	}
	
	@PutMapping(path = "actualizar-norma-clasificada")
	public int actualizarNormaClasificada(@RequestBody NormaClasificacion normaClasificacion) {
		
		return normaService.actualizarNormaClasificada(normaClasificacion);
		
	}
	
	@PostMapping(path = "registrar-norma-grupo")
	public int registrarNormaGrupo(@RequestBody NormaGrupo normaGrupo) {

		return normaService.registrarNormaGrupo(normaGrupo);
		
	}
	
	@PutMapping(path = "actualizar-norma-grupo")
	public int actualizarNormaGrupo(@RequestBody NormaGrupo normaGrupo) {
		
		return normaService.actualizarNormaGrupo(normaGrupo);
		
	}

}
