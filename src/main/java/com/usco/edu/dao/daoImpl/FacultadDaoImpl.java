package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IFacultadDao;
import com.usco.edu.entities.Facultad;
import com.usco.edu.resultSetExtractor.FacultadSetExtractor;

@Repository
public class FacultadDaoImpl implements IFacultadDao{
	
	@Autowired
	@Qualifier("JDBCTemplateUscoEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;
	
	@Autowired
	@Qualifier("JDBCTemplateUscoConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<Facultad> obtenerListadoFacultades() {
		
		String sql = "select * from facultad f "
				+ "inner join sede s on f.sed_codigo = s.sed_codigo "
				+ "inner join cabeceras_centros_poblados ccp on s.ccp_divipola = ccp.ccp_divipola  "
				+ "inner join municipio m on ccp.mun_divipola = m.mun_divipola "
				+ "inner join departamento d on m.dep_divipola = d.dep_divipola "
				+ "inner join pais p on d.pai_codigo = p.pai_codigo "
				+ "inner join sede_tipo st on s.set_tipo = st.set_codigo "
				+ "where f.fac_estado = 1 "
				+ "order by f.fac_codigo desc";
		return jdbcTemplate.query(sql, new FacultadSetExtractor());
		
	}
	
	@Override
	public List<Facultad> obtenerListadoFacultadSede(int sedeCodigo) {
		
		String sql = "select * from facultad f "
				+ "inner join sede s on f.sed_codigo = s.sed_codigo "
				+ "inner join cabeceras_centros_poblados ccp on s.ccp_divipola = ccp.ccp_divipola  "
				+ "inner join municipio m on ccp.mun_divipola = m.mun_divipola "
				+ "inner join departamento d on m.dep_divipola = d.dep_divipola "
				+ "inner join pais p on d.pai_codigo = p.pai_codigo "
				+ "inner join sede_tipo st on s.set_tipo = st.set_codigo "
				+ "where f.fac_estado = 1 and f.sed_codigo = " + sedeCodigo + " "
				+ "order by f.fac_codigo desc";
		return jdbcTemplate.query(sql, new FacultadSetExtractor());
		
	}

	@Override
	public int registrar(Facultad facultad) {
		String sql = "INSERT INTO facultad "
				+ "(sed_codigo, fac_nombre, fac_decano, fac_correo, fac_telefono) "
				+ "VALUES(?, ?, ?, ?, ?);";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				facultad.getSede().getCodigo(),
				facultad.getNombre(),
				facultad.getDecano(),
				facultad.getCorreo(),
				facultad.getTelefono(),
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("sede", facultad.getSede().getCodigo());
			parameter.addValue("nombre", facultad.getNombre());
			parameter.addValue("decano", facultad.getDecano());
			parameter.addValue("correo", facultad.getCorreo());
			parameter.addValue("telefono", facultad.getTelefono());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
	}

	@Override
	public int actualizar(Facultad facultad) {
		String sql = "UPDATE facultad "
				+ "SET sed_codigo = ?, fac_nombre = ?, fac_decano = ?, fac_correo = ?, fac_telefono = ?, fac_estado = ? "
				+ "WHERE fac_codigo = ?;";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				facultad.getSede().getCodigo(),
				facultad.getNombre(),
				facultad.getDecano(),
				facultad.getCorreo(),
				facultad.getTelefono(),
				facultad.getEstado(),
				facultad.getCodigo()
				});

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("sede", facultad.getSede().getCodigo());
			parameter.addValue("nombre", facultad.getNombre());
			parameter.addValue("decano", facultad.getDecano());
			parameter.addValue("correo", facultad.getCorreo());
			parameter.addValue("telefono", facultad.getTelefono());
			parameter.addValue("estado", facultad.getEstado());
			parameter.addValue("codigo", facultad.getCodigo());

			return result;
			
		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
	}

}
