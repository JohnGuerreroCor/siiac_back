package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IPersonaDao;
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

@Service
public class PersonaServiceImpl implements IPersonaService{
	
	@Autowired
	private IPersonaDao personaDao;
	
	@Override
	public List<Persona> obtenerPersonaIdentificacion(String id) {
		
		return personaDao.obtenerPersonaIdentificacion(id);
		
	}

	@Override
	public List<TipoIdentificacion> obtenerTipoId() {
		
		return personaDao.obtenerTipoId();
	}

	@Override
	public List<SexoBiologico> obtenerSexoBiologico() {
		
		return personaDao.obtenerSexoBiologico();
		
	}

	@Override
	public List<GrupoSanguineo> obtenerGrupoSanguineo() {
		
		return personaDao.obtenerGrupoSanguineo();
		
	}

	@Override
	public List<EstadoCivil> obtenerEstadoCivil() {
		
		return personaDao.obtenerEstadoCivil();
		
	}

	@Override
	public List<ComunidadNegra> obtenerComunidadesNegras() {
		
		return personaDao.obtenerComunidadesNegras();
		
	}
	
	@Override
	public List<DiscapacidadTipo> obtenerTiposDiscapacidades() {
		
		return personaDao.obtenerTiposDiscapacidades();
		
	}

	@Override
	public List<Estrato> obtenerEstratos() {
		
		return personaDao.obtenerEstratos();
		
	}

	@Override
	public List<GrupoEtnico> obtenerGruposEtnicos() {
		
		return personaDao.obtenerGruposEtnicos();
		
	}

	@Override
	public List<PersonaDiscapacidad> obtenerPersonasDiscapacidad() {
		
		return personaDao.obtenerPersonasDiscapacidad();
		
	}

	@Override
	public List<PuebloIndigena> obtenerPueblosIndigenas() {
		
		return personaDao.obtenerPueblosIndigenas();
		
	}

	@Override
	public List<TalentoExcepcional> obtenerTalentosExcepcionales() {
		
		return personaDao.obtenerTalentosExcepcionales();
		
	}

	@Override
	public List<Persona> obtenerPersonas() {
		
		return personaDao.obtenerPersonas();
		
	}

	@Override
	public int registrar(Persona persona) {
		
		return personaDao.registrar(persona);
		
	}

	@Override
	public int actualizar(Persona persona) {
		
		return personaDao.actualizar(persona);
		
	}

}
