package com.usco.edu.service;

import java.util.List;

import com.usco.edu.entities.PersonaCarnet;

public interface IPersonaService {
	public List<PersonaCarnet> buscarPorPerCodigo(int codigo);
	public List<PersonaCarnet> buscarPorIdentificacion(String id);

}
