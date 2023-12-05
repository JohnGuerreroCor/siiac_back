package com.usco.edu.dao.daoImpl;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.ICuerpoColegiadoDao;
import com.usco.edu.entities.CuerpoColegiado;
import com.usco.edu.entities.FuncionesCuerpoColegiado;
import com.usco.edu.entities.IntegranteCuerpoColegiado;
import com.usco.edu.resultSetExtractor.CuerpoColegiadoSetExtractor;
import com.usco.edu.resultSetExtractor.FuncionesCuerpoColegiadoSetExtractor;
import com.usco.edu.resultSetExtractor.IntegranteCuerpoColegiadoSetExtractor;
import com.usco.edu.rowMapper.CuerpoColegiadoDisponibilidadRowMapper;

@Repository
public class CuerpoColegiadoDaoImpl implements ICuerpoColegiadoDao{
	
	@Autowired
	@Qualifier("JDBCTemplateUscoEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;
	
	@Autowired
	@Qualifier("JDBCTemplateUscoConsulta")
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public List<CuerpoColegiado> obtenerListadoCuerposColegiados() {
		
		String sql = "select * from cuerpos_colegiados cc "
				+ "where cc.cuc_estado = 1 ";
		return jdbcTemplate.query(sql, new CuerpoColegiadoSetExtractor());
		
	}
	
	@Override
	public List<CuerpoColegiado> obtenerCuerpoColegiadoDisponibilidad() {
		
		String sql = "select cc.cuc_codigo, cc.cuc_nombre, cc.cuc_cantidad_miembros, count(icc.icc_estado) as asignados from cuerpos_colegiados cc "
				+ "left join integrante_cuerpo_colegiado icc on cc.cuc_codigo = icc.cuc_codigo and icc.icc_estado = 1 "
				+ "where cc.cuc_estado = 1 "
				+ "group by cc.cuc_nombre, cc.cuc_cantidad_miembros,cc.cuc_codigo";
		return jdbcTemplate.query(sql, new CuerpoColegiadoDisponibilidadRowMapper());
		
	}
	
	@Override
	public List<FuncionesCuerpoColegiado> obtenerListadoFunciones(int codigoCuerpoColegiado) {
		
		String sql = "select * from funciones_curpos_colegiados f "
				+ "left join cuerpos_colegiados cc on f.cuc_codigo = cc.cuc_codigo "
				+ "where f.cuc_codigo = " + codigoCuerpoColegiado + " and f.fcc_estado = 1 ";
		return jdbcTemplate.query(sql, new FuncionesCuerpoColegiadoSetExtractor());
		
	}
	
	@Override
	public List<IntegranteCuerpoColegiado> obtenerListadoIntegrantesCuerpoColegiado() {
		
		String sql = "select * from integrante_cuerpo_colegiado icc "
				+ "inner join cuerpos_colegiados cc on icc.cuc_codigo = cc.cuc_codigo "
				+ "inner join persona p on icc.per_codigo = p.per_codigo "
				+ "left join usuario_tipo ut ON icc.ust_codigo = ut.ust_codigo "
				+ "left join miembro_tipo mt on icc.mit_codigo = mt.mit_codigo "
				+ "order by icc.icc_fecha_inicio ";
		return jdbcTemplate.query(sql, new IntegranteCuerpoColegiadoSetExtractor());
		
	}

	@Override
	public List<IntegranteCuerpoColegiado> obtenerListadoIntegrantesCuerpoColegiadoCodigo(int codigoCuerpoColegiado) {
		
		String sql = "select * from integrante_cuerpo_colegiado icc "
				+ "inner join cuerpos_colegiados cc on icc.cuc_codigo = cc.cuc_codigo "
				+ "inner join persona p on icc.per_codigo = p.per_codigo "
				+ "left join usuario_tipo ut ON icc.ust_codigo = ut.ust_codigo "
				+ "left join miembro_tipo mt on icc.mit_codigo = mt.mit_codigo "
				+ "where icc.cuc_codigo = " + codigoCuerpoColegiado + " " 
				+ "order by icc.icc_fecha_inicio ";
		return jdbcTemplate.query(sql, new IntegranteCuerpoColegiadoSetExtractor());
		
	}

	@Override
	public int registrarCuerpoColegiado(CuerpoColegiado cuerposColegiados) {
		
		String sql = "INSERT INTO cuerpos_colegiados "
				+ "(cuc_nombre, cuc_nombre_corto, cuc_numero_norma, cuc_nombre_norma, cuc_fecha_norma, cuc_cantidad_miembros) "
				+ "VALUES(?, ?, ?, ?, ?, ?);";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				cuerposColegiados.getNombre(),
				cuerposColegiados.getNombreCorto(),
				cuerposColegiados.getNumeroNorma(),
				cuerposColegiados.getNombreNorma(),
				cuerposColegiados.getFechaNorma(),
				cuerposColegiados.getCantidadMiembros(),
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("nombre", cuerposColegiados.getNombre());
			parameter.addValue("nombreCorto", cuerposColegiados.getNombreCorto());
			parameter.addValue("numeroNorma", cuerposColegiados.getNumeroNorma());
			parameter.addValue("nombreNorma", cuerposColegiados.getNombreNorma());
			parameter.addValue("fechaNorma", cuerposColegiados.getFechaNorma());
			parameter.addValue("cantidadMiembros", cuerposColegiados.getCantidadMiembros());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
	}

	@Override
	public int actualizarCuerpoColegiado(CuerpoColegiado cuerposColegiados) {
		
		String sql = "UPDATE cuerpos_colegiados "
				+ "SET cuc_nombre=?, cuc_nombre_corto=?, cuc_numero_norma=?, cuc_nombre_norma=?, cuc_fecha_norma=?, cuc_cantidad_miembros=?, cuc_estado=?"
				+ "WHERE cuc_codigo = ? ;";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				cuerposColegiados.getNombre(),
				cuerposColegiados.getNombreCorto(),
				cuerposColegiados.getNumeroNorma(),
				cuerposColegiados.getNombreNorma(),
				cuerposColegiados.getFechaNorma(),
				cuerposColegiados.getCantidadMiembros(),
				cuerposColegiados.getEstado(),
				cuerposColegiados.getCodigo(),
				});

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("nombre", cuerposColegiados.getNombre());
			parameter.addValue("nombreCorto", cuerposColegiados.getNombreCorto());
			parameter.addValue("numeroNorma", cuerposColegiados.getNumeroNorma());
			parameter.addValue("nombreNorma", cuerposColegiados.getNombreNorma());
			parameter.addValue("fechaNorma", cuerposColegiados.getFechaNorma());
			parameter.addValue("cantidadMiembros", cuerposColegiados.getCantidadMiembros());
			parameter.addValue("estado", cuerposColegiados.getEstado());
			parameter.addValue("codigo", cuerposColegiados.getCodigo());

			return result;
			
		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
		
	}

	@Override
	public int registrarFuncion(FuncionesCuerpoColegiado funcion) {
		String sql = "INSERT INTO funciones_curpos_colegiados "
				+ "(cuc_codigo, fcc_nombre) "
				+ "VALUES(?, ?);";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				funcion.getCuerpoColegiado().getCodigo(),
				funcion.getNombre(),
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("codigoCuerpoColegiado", funcion.getCuerpoColegiado().getCodigo());
			parameter.addValue("nombre", funcion.getNombre());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
	}

	@Override
	public int actualizarFuncion(FuncionesCuerpoColegiado funcion) {
		String sql = "UPDATE funciones_curpos_colegiados "
				+ "SET fcc_nombre= ?, fcc_estado= ? "
				+ "WHERE fcc_codigo = ?;";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				funcion.getNombre(),
				funcion.getEstado(),
				funcion.getCodigo(),
				});

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("nombre", funcion.getNombre());
			parameter.addValue("estado", funcion.getEstado());
			parameter.addValue("codigo", funcion.getCodigo());

			return result;
			
		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
	}

	@Override
	public int registrarIntegrante(IntegranteCuerpoColegiado integrante) {
		
		String sql = "INSERT INTO integrante_cuerpo_colegiado "
				+ "(cuc_codigo, per_codigo, icc_norma, ust_codigo, mit_codigo, icc_fecha_inicio, icc_fecha_fin, icc_observacicon) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				integrante.getCuerpoColegiado().getCodigo(),
				integrante.getPersonaCodigo(),
				integrante.getCodigoNorma(),
				integrante.getUsuarioTipo().getCodigo(),
				integrante.getMiembroTipo().getCodigo(),
				integrante.getFechaInicio(),
				integrante.getFechaFin(),
				integrante.getObservacion()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("cuerpoColegiado", integrante.getCuerpoColegiado().getCodigo());
			parameter.addValue("personaCodigo", integrante.getPersonaCodigo());
			parameter.addValue("codigoNorma", integrante.getCodigoNorma());
			parameter.addValue("usuarioTipo", integrante.getUsuarioTipo().getCodigo());
			parameter.addValue("miembroTipo", integrante.getMiembroTipo().getCodigo());
			parameter.addValue("fechaInicio", integrante.getFechaInicio());
			parameter.addValue("fechaFin", integrante.getFechaFin(), Types.DATE);
			parameter.addValue("observacion", integrante.getObservacion());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
		
	}

	@Override
	public int actualizarIntegrante(IntegranteCuerpoColegiado integrante) {
		
		String sql = "UPDATE integrante_cuerpo_colegiado "
				+ "SET cuc_codigo= ?, per_codigo= ?, icc_norma= ?, ust_codigo= ?, mit_codigo= ?, icc_fecha_inicio= ?, icc_fecha_fin= ?, icc_observacicon= ?, icc_estado= ? "
				+ "WHERE icc_codigo = ?;";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				integrante.getCuerpoColegiado().getCodigo(),
				integrante.getPersonaCodigo(),
				integrante.getCodigoNorma(),
				integrante.getUsuarioTipo().getCodigo(),
				integrante.getMiembroTipo().getCodigo(),
				integrante.getFechaInicio(),
				integrante.getFechaFin(),
				integrante.getObservacion(),
				integrante.getEstado(),
				integrante.getCodigo()
				});

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("cuerpoColegiado", integrante.getCuerpoColegiado().getCodigo());
			parameter.addValue("personaCodigo", integrante.getPersonaCodigo());
			parameter.addValue("codigoNorma", integrante.getCodigoNorma());
			parameter.addValue("usuarioTipo", integrante.getUsuarioTipo().getCodigo());
			parameter.addValue("miembroTipo", integrante.getMiembroTipo().getCodigo());
			parameter.addValue("fechaInicio", integrante.getFechaInicio());
			parameter.addValue("fechaFin", integrante.getFechaFin(), Types.DATE);
			parameter.addValue("observacion", integrante.getObservacion());
			parameter.addValue("estado", integrante.getEstado());
			parameter.addValue("codigo", integrante.getCodigo());

			return result;
			
		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
		
	}
	
}
