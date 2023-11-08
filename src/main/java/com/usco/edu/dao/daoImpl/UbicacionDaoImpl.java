package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IUbicacionDao;
import com.usco.edu.resultSetExtractor.CabecerasCentrosPobladosSetExtractor;
import com.usco.edu.resultSetExtractor.DepartamentoSetExtractor;
import com.usco.edu.resultSetExtractor.MunicipioSetExtractor;
import com.usco.edu.resultSetExtractor.PaisSetExtractor;
import com.usco.edu.entities.Pais;
import com.usco.edu.entities.CabecerasCentrosPoblados;
import com.usco.edu.entities.Departamento;
import com.usco.edu.entities.Municipio;

@Repository
public class UbicacionDaoImpl implements IUbicacionDao{
	
	
	@Autowired
	@Qualifier("JDBCTemplateUscoConsulta")
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Pais> obtenerPaisLocal() {
		
		String sql = "select * from pais p where p.pai_codigo = 43";

		return jdbcTemplate.query(sql, new PaisSetExtractor());
	}

	@Override
	public List<Pais> obtenerPaises() {
		
		String sql = "select * from pais ";

		return jdbcTemplate.query(sql, new PaisSetExtractor());
		
	}

	@Override
	public List<Departamento> obtenerDepartamentosPorPais(int paiCodigo) {
		String sql = "select * from departamento d "
				+ "inner join pais p on d.pai_codigo = p.pai_codigo "
				+ "where d.pai_codigo = "+ paiCodigo + " ";

		return jdbcTemplate.query(sql, new DepartamentoSetExtractor());
	}

	@Override
	public List<Municipio> obtenerMunicipiosPorDepartamento(String depCodigo) {
		String sql = "select * from municipio m "
				+ "inner join departamento d on m.dep_divipola = d.dep_divipola "
				+ "inner join pais p on d.pai_codigo = p.pai_codigo "
				+ "where m.dep_divipola = '" + depCodigo + "'";

		return jdbcTemplate.query(sql, new MunicipioSetExtractor());
	}

	@Override
	public List<CabecerasCentrosPoblados> obtenerCcpPorMunicipio(String munCodigo) {
		String sql = "select * from cabeceras_centros_poblados ccp "
				+ "inner join municipio m on ccp.mun_divipola = m.mun_divipola "
				+ "inner join departamento d on m.dep_divipola = d.dep_divipola "
				+ "inner join pais p on d.pai_codigo = p.pai_codigo "
				+ "where ccp.mun_divipola = '" + munCodigo + "'";

		return jdbcTemplate.query(sql, new CabecerasCentrosPobladosSetExtractor());
	}

	@Override
	public List<Departamento> obtenerDepartamentos() {
		
		String sql = "select * from departamento d ";

		return jdbcTemplate.query(sql, new DepartamentoSetExtractor());
		
	}

	@Override
	public List<Municipio> obtenerMunicipios() {
		
		String sql = "select * from municipio m "
				+ "inner join departamento d on m.dep_divipola = d.dep_divipola "
				+ "inner join pais p on d.pai_codigo = p.pai_codigo ";

		return jdbcTemplate.query(sql, new MunicipioSetExtractor());
		
	}

	@Override
	public List<CabecerasCentrosPoblados> obtenerCcp() {
		
		String sql = "select * from cabeceras_centros_poblados ccp ";
		
		return jdbcTemplate.query(sql, new CabecerasCentrosPobladosSetExtractor());
		
	}

}

