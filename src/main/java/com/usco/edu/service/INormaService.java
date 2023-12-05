package com.usco.edu.service;

import java.util.List;

import com.usco.edu.entities.EntidadExterna;
import com.usco.edu.entities.Norma;
import com.usco.edu.entities.NormaClasificacion;
import com.usco.edu.entities.NormaDeroga;
import com.usco.edu.entities.NormaGrupo;
import com.usco.edu.entities.NormaTipo;

public interface INormaService {
	
	public List<Norma> obtenerNormas();
	
	public List<Norma> obtenerNorma(int normaCodigo);
	
	public List<Norma> obtenerNormasNoDerogadas();
	
	public List<EntidadExterna> obtenerEntidadesExternas();
	
	public List<NormaTipo> obtenerNormasTipo(int entidadCodigo);
	
	public int registrarNorma(Norma norma);
	
	public int actualizarNorma(Norma norma);
	
	public int suspenderNorma(Norma norma);
	
///////DEROGACIÓN
	
	public List<NormaDeroga> obtenerNormaDerogada(int norma);
	
	public int registrarNormaDeroga(NormaDeroga deroga);
	
	public int actualizarNormaDeroga(NormaDeroga deroga);
	
///////CLASIFICACION
	
	public List<NormaGrupo> obtenerNormaGruposAgrupados();
	
	public List<NormaGrupo> obtenerNormaGrupos();
	
	public List<Norma> obtenerNormaSinClasificar(int normaGrupoCodigo);
	
	public List<NormaClasificacion> obtenerNormaClasificada(int normaGrupoCodigo);
	
	public int registrarNormaClasificada(NormaClasificacion normaClasificacion);
	
	public int actualizarNormaClasificada(NormaClasificacion normaClasificacion);
	
	public int registrarNormaGrupo(NormaGrupo normaGrupo);
	
	public int actualizarNormaGrupo(NormaGrupo normaGrupo);

}
