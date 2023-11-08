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

import com.usco.edu.entities.ComunidadNegra;
import com.usco.edu.entities.DiscapacidadTipo;
import com.usco.edu.entities.EstadoCivil;
import com.usco.edu.entities.Estrato;
import com.usco.edu.entities.GrupoEtnico;
import com.usco.edu.entities.GrupoSanguineo;
import com.usco.edu.entities.Persona;
import com.usco.edu.entities.PersonaDiscapacidad;
import com.usco.edu.entities.PuebloIndigena;
import com.usco.edu.entities.SexoBiologico;
import com.usco.edu.entities.TalentoExcepcional;
import com.usco.edu.entities.TipoIdentificacion;
import com.usco.edu.service.IPersonaService;

@RestController
@RequestMapping(path = "persona")
public class PersonaRestController {
	
	@Autowired
	IPersonaService personaService;
	
	@GetMapping(path = "obtener-personas")
	public List<Persona> obtenerPersonas() {
		
		return personaService.obtenerPersonas();
		
	}
	
	@GetMapping(path = "obtener-persona-identificacion/{id}")
	public List<Persona> obtenerPersonaIdentificacion(@PathVariable String id) {
		
		return personaService.obtenerPersonaIdentificacion(id);
		
	}
	
	@GetMapping(path = "obtener-tipo-id")
	public List<TipoIdentificacion> obtenerPaisLocal() {
		
		return personaService.obtenerTipoId();
		
	}
	
	@GetMapping(path = "obtener-sexo-biologico")
	public List<SexoBiologico> obtenerSexoBiologico() {
		
		return personaService.obtenerSexoBiologico();
		
	}
	
	@GetMapping(path = "obtener-grupo-sanguineo")
	public List<GrupoSanguineo> obtenerGrupoSanguineo() {
		
		return personaService.obtenerGrupoSanguineo();
		
	}
	
	@GetMapping(path = "obtener-estado-civil")
	public List<EstadoCivil> obtenerEstadoCivil() {
		
		return personaService.obtenerEstadoCivil();
		
	}
	
	@GetMapping(path = "obtener-comunidades-negras")
	public List<ComunidadNegra> obtenerComunidadesNegras() {
		
		return personaService.obtenerComunidadesNegras();
		
	}
	
	@GetMapping(path = "obtener-tipos-discapacidades")
	public List<DiscapacidadTipo> obtenerTiposDiscapacidades() {
		
		return personaService.obtenerTiposDiscapacidades();
		
	}
	
	@GetMapping(path = "obtener-estratos")
	public List<Estrato> obtenerEstratos() {
		
		return personaService.obtenerEstratos();
		
	}
	
	@GetMapping(path = "obtener-grupos-etnicos")
	public List<GrupoEtnico> obtenerGruposEtnicos() {
		
		return personaService.obtenerGruposEtnicos();
		
	}
	
	@GetMapping(path = "obtener-personas-discapacidad")
	public List<PersonaDiscapacidad> obtenerPersonasDiscapacidad() {
		
		return personaService.obtenerPersonasDiscapacidad();
		
	}
	
	@GetMapping(path = "obtener-pueblos-indigenas")
	public List<PuebloIndigena> obtenerPueblosIndigenas() {
		
		return personaService.obtenerPueblosIndigenas();
		
	}
	
	@GetMapping(path = "obtener-talentos-excepcionales")
	public List<TalentoExcepcional> obtenerTalentosExcepcionales() {
		
		return personaService.obtenerTalentosExcepcionales();
		
	}
	
	@PostMapping(path = "registrar-persona")
	public int registrar(@RequestBody Persona persona) {

		return personaService.registrar(persona);
		
	}
	
	@PutMapping(path = "actualizar-persona")
	public int actualizar(@RequestBody Persona persona) {
		
		return personaService.actualizar(persona);
		
	}

}
