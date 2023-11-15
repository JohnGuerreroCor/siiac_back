package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.usco.edu.dao.IInstitucionDao;
import com.usco.edu.entities.CaracterAcademico;
import com.usco.edu.entities.Institucion;
import com.usco.edu.entities.NaturalezaJuridica;
import com.usco.edu.entities.Sector;
import com.usco.edu.resultSetExtractor.CaracterAcademicoSetExtractor;
import com.usco.edu.resultSetExtractor.InstitucionSetExtractor;
import com.usco.edu.resultSetExtractor.NaturalezaJuridicaSetExtractor;
import com.usco.edu.resultSetExtractor.SectorSetExtractor;

@Repository
public class InstitucionDaoImpl implements IInstitucionDao{
	
	@Autowired
	@Qualifier("JDBCTemplateUscoEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;
	
	@Autowired
	@Qualifier("JDBCTemplateUscoConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<CaracterAcademico> obtenerListadoCaracterAcademico() {
		String sql = "select * from caracter_academico ca where ca.caa_estado = 1";
		return jdbcTemplate.query(sql, new CaracterAcademicoSetExtractor());
	}

	@Override
	public List<NaturalezaJuridica> obtenerListadoNaturalezaJuridica() {
		String sql = "select * from naturaleza_juridica nj where nj.naj_estado = 1";
		return jdbcTemplate.query(sql, new NaturalezaJuridicaSetExtractor());
	}

	@Override
	public List<Sector> obtenerListadoSector() {
		String sql = "select * from sector s where s.sec_estado = 1";
		return jdbcTemplate.query(sql, new SectorSetExtractor());
	}
	
	@Override
	public List<Institucion> obtenerInstitucion() {
		String sql = "SELECT DISTINCT ON (i.ins_nit) i.ins_nit, i.*, nj.*, s.*, ca.*, ccp.*, m.*, d.*, p.*, n.* "
				+ "FROM institucion i "
				+ "INNER JOIN naturaleza_juridica nj ON i.naj_codigo = nj.naj_codigo "
				+ "INNER JOIN sector s ON i.sec_codigo = s.sec_codigo "
				+ "INNER JOIN caracter_academico ca ON i.caa_codigo = ca.caa_codigo "
				+ "INNER JOIN cabeceras_centros_poblados ccp ON i.ccp_divipola = ccp.ccp_divipola "
				+ "INNER JOIN municipio m ON ccp.mun_divipola = m.mun_divipola "
				+ "INNER JOIN departamento d ON m.dep_divipola = d.dep_divipola "
				+ "INNER JOIN pais p ON d.pai_codigo = p.pai_codigo "
				//+ "INNER JOIN norma n on i.nor_codigo = n.nor_codigo "
				//+ "inner join norma_tipo nt on n.not_codigo = nt.not_codigo "
				+ "ORDER BY i.ins_nit, i.ins_codigo DESC;";
		return jdbcTemplate.query(sql, new InstitucionSetExtractor());
	}

	@Override
	public List<Institucion> obtenerListadoInstitucion() {
		String sql = "select * from institucion i "
				+ "inner join naturaleza_juridica nj on i.naj_codigo = nj.naj_codigo "
				+ "inner join sector s on i.sec_codigo = s.sec_codigo "
				+ "inner join caracter_academico ca on i.caa_codigo = ca.caa_codigo "
				+ "inner join cabeceras_centros_poblados ccp on i.ccp_divipola = ccp.ccp_divipola "
				+ "inner join municipio m on ccp.mun_divipola = m.mun_divipola "
				+ "inner join departamento d on m.dep_divipola = d.dep_divipola "
				+ "inner join pais p on d.pai_codigo = p.pai_codigo "
				//+ "inner join norma n on i.nor_codigo = n.nor_codigo "
				//+ "inner join norma_tipo nt on n.not_codigo = nt.not_codigo "
				+ "order by i.ins_codigo desc";
		return jdbcTemplate.query(sql, new InstitucionSetExtractor());
	}

	@Override
	public int registrar(Institucion institucion) {
		String sql = "INSERT INTO institucion "
				+ "(ins_nit, ins_snies, ins_snies_padre, naj_codigo, sec_codigo, caa_codigo, ins_nombre, ccp_divipola, ins_direccion, ins_telefono, ins_pagina_web, nor_codigo, ins_fecha_norma) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				institucion.getNit(),
				institucion.getIes(),
				institucion.getIesPadre(),
				institucion.getNaturaleza().getCodigo(),
				institucion.getSector().getCodigo(),
				institucion.getCaracter().getCodigo(),
				institucion.getNombre(),
				institucion.getCcp().getDivipola(),
				institucion.getDireccion(),
				institucion.getTelefono(),
				institucion.getUrl(),
				institucion.getNormaCodigo(),
				institucion.getFechaNorma(),
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("nit", institucion.getNit());
			parameter.addValue("ies", institucion.getIes());
			parameter.addValue("iesPadre", institucion.getIesPadre());
			parameter.addValue("naturaleza", institucion.getNaturaleza().getCodigo());
			parameter.addValue("sector", institucion.getSector().getCodigo());
			parameter.addValue("caracter", institucion.getCaracter().getCodigo());
			parameter.addValue("nombre", institucion.getNombre());
			parameter.addValue("ccp", institucion.getCcp().getDivipola());
			parameter.addValue("direccion", institucion.getDireccion());
			parameter.addValue("telefono", institucion.getTelefono());
			parameter.addValue("url", institucion.getUrl());
			parameter.addValue("norma", institucion.getNormaCodigo());
			parameter.addValue("fechaNorma", institucion.getFechaNorma());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
	}

	@Override
	public int actualizar(Institucion institucion) {
		// TODO Auto-generated method stub
		return 0;
	}

}
