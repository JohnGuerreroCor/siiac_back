package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.Estudiante;

public interface IEstudianteDao {
	public List<Estudiante> findByCodigo(String codigo);
	
}
