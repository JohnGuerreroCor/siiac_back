package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.TipoIdentificacion;
import com.usco.edu.entities.ComunidadNegra;
import com.usco.edu.entities.DiscapacidadTipo;
import com.usco.edu.entities.EstadoCivil;
import com.usco.edu.entities.Estrato;
import com.usco.edu.entities.GrupoEtnico;
import com.usco.edu.entities.GrupoSanguineo;
import com.usco.edu.entities.PersonaDiscapacidad;
import com.usco.edu.entities.PuebloIndigena;
import com.usco.edu.entities.Persona;
import com.usco.edu.entities.SexoBiologico;
import com.usco.edu.entities.TalentoExcepcional;

public interface IPersonaDao {
	
	public List<Persona> obtenerPersonas();
	
	public List<Persona> obtenerPersonaIdentificacion(String id);
	
	public List<TipoIdentificacion> obtenerTipoId();
	
	public List<SexoBiologico> obtenerSexoBiologico();
	
	public List<GrupoSanguineo> obtenerGrupoSanguineo();
	
	public List<EstadoCivil> obtenerEstadoCivil();
	
	public List<ComunidadNegra> obtenerComunidadesNegras();
	
	public List<DiscapacidadTipo> obtenerTiposDiscapacidades();
	
	public List<Estrato> obtenerEstratos();
	
	public List<GrupoEtnico> obtenerGruposEtnicos();
	
	public List<PersonaDiscapacidad> obtenerPersonasDiscapacidad();
	
	public List<PuebloIndigena> obtenerPueblosIndigenas();
	
	public List<TalentoExcepcional> obtenerTalentosExcepcionales();
	
	public int registrar(Persona persona);
	
	int actualizar(Persona persona);

}
