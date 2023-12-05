package com.usco.edu.dao.daoImpl;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.INormaDao;
import com.usco.edu.entities.EntidadExterna;
import com.usco.edu.entities.Norma;
import com.usco.edu.entities.NormaClasificacion;
import com.usco.edu.entities.NormaDeroga;
import com.usco.edu.entities.NormaGrupo;
import com.usco.edu.entities.NormaTipo;
import com.usco.edu.resultSetExtractor.EntidadExternaSetExtractor;
import com.usco.edu.resultSetExtractor.NormaClasificacionSetExtractor;
import com.usco.edu.resultSetExtractor.NormaDerogaSetExtractor;
import com.usco.edu.resultSetExtractor.NormaGrupoCantidadSetExtractor;
import com.usco.edu.resultSetExtractor.NormaGrupoSetExtractor;
import com.usco.edu.resultSetExtractor.NormaSetExtractor;
import com.usco.edu.resultSetExtractor.NormaTipoSetExtractor;


@Repository
public class NormaDaoImpl implements INormaDao{
	
	@Autowired
	@Qualifier("JDBCTemplateUscoEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;
	
	@Autowired
	@Qualifier("JDBCTemplateUscoConsulta")
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Norma> obtenerNormas() {
		
		String sql = "select *, nt2.not_nombre + ' ' + n2.nor_numero + ' ' + n2.nor_nombre as deroga_padre from norma n "
				+ "inner join norma_entidad ne on n.noe_codigo = ne.noe_codigo "
				+ "inner join norma_tipo nt on n.not_codigo = nt.not_codigo "
				+ "inner join norma_medio nm on n.nom_codigo = nm.nom_codigo "
				+ "left join cuerpos_colegiados cc on n.cuc_codigo = cc.cuc_codigo "
				+ "left join entidad_externa ee on n.ene_codigo = ee.ene_codigo "
				+ "left join norma_deroga nd on n.nor_codigo = nd.nor_codigo_hijo and nd.nod_estado = 1 "
				+ "left join norma n2 on nd.nor_codigo_padre = n2.nor_codigo "
				+ "left join norma_tipo nt2 on nt2.not_codigo = n2.not_codigo "
				+ "where n.nor_estado = 1";
		return jdbcTemplate.query(sql, new NormaSetExtractor());
		
	}
	
	@Override
	public List<Norma> obtenerNorma(int normaCodigo) {
		
		String sql = "select *, nt2.not_nombre + ' ' + n2.nor_numero + ' ' + n2.nor_nombre as deroga_padre from norma n "
				+ "inner join norma_entidad ne on n.noe_codigo = ne.noe_codigo "
				+ "inner join norma_tipo nt on n.not_codigo = nt.not_codigo "
				+ "inner join norma_medio nm on n.nom_codigo = nm.nom_codigo "
				+ "left join cuerpos_colegiados cc on n.cuc_codigo = cc.cuc_codigo "
				+ "left join entidad_externa ee on n.ene_codigo = ee.ene_codigo "
				+ "left join norma_deroga nd on n.nor_codigo = nd.nor_codigo_hijo and nd.nod_estado = 1 "
				+ "left join norma n2 on nd.nor_codigo_padre = n2.nor_codigo "
				+ "left join norma_tipo nt2 on nt2.not_codigo = n2.not_codigo "
				+ "where n.nor_estado = 1 and n.nor_codigo= " + normaCodigo;
		return jdbcTemplate.query(sql, new NormaSetExtractor());
		
	}
	
	@Override
	public List<Norma> obtenerNormasNoDerogadas() {
		
		String sql = "select *, nt2.not_nombre + ' ' + n2.nor_numero + ' ' + n2.nor_nombre as deroga_padre FROM norma n "
				+ "inner join norma_entidad ne on n.noe_codigo = ne.noe_codigo "
				+ "inner join norma_tipo nt on n.not_codigo = nt.not_codigo "
				+ "inner join norma_medio nm on n.nom_codigo = nm.nom_codigo "
				+ "left join cuerpos_colegiados cc on n.cuc_codigo = cc.cuc_codigo "
				+ "left join entidad_externa ee on n.ene_codigo = ee.ene_codigo "
				+ "left join norma_deroga nd on n.nor_codigo = nd.nor_codigo_hijo and nd.nod_estado = 1 "
				+ "left join norma n2 on nd.nor_codigo_padre = n2.nor_codigo "
				+ "left join norma_tipo nt2 on nt2.not_codigo = n2.not_codigo "
				+ "WHERE n.nor_estado = 1 and NOT EXISTS ( SELECT * FROM norma_deroga nd WHERE n.nor_codigo = nd.nor_codigo_hijo and nd.nod_estado != 0 ); ";
		return jdbcTemplate.query(sql, new NormaSetExtractor());
		
	}

	@Override
	public List<EntidadExterna> obtenerEntidadesExternas() {
		
		String sql = "select * from entidad_externa ee where ee.ene_estado = 1 order by ee.ene_nombre asc";
		return jdbcTemplate.query(sql, new EntidadExternaSetExtractor());
		
	}

	@Override
	public List<NormaTipo> obtenerNormasTipo(int entidadCodigo) {
		
		String sql = "select * from norma_tipo nt "
				+ "inner join norma_entidad ne on nt.noe_codigo = ne.noe_codigo "
				+ "where nt.noe_codigo = " + entidadCodigo + " and nt.not_estado = 1 order by nt.not_nombre asc";
		return jdbcTemplate.query(sql, new NormaTipoSetExtractor());
		
	}

	@Override
	public int registrarNorma(Norma norma) {
		String sql = "INSERT INTO norma "
				+ "(noe_codigo, ene_codigo, nor_rectoria, cuc_codigo, not_codigo, nor_numero, nor_nombre, nor_url, nom_codigo, nor_fecha_expedicion, nor_fecha_vigencia, nor_deroga, nor_observacion) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				norma.getEntidadCodigo(),
				norma.getEntidadExternaCodigo(),
				norma.getRectoria(),
				norma.getCuerpoColegiadoCodigo(),
				norma.getNormaTipoCodigo(),
				norma.getNumero(),
				norma.getNombre(),
				norma.getUrl(),
				norma.getMedioCodigo(),
				norma.getFechaExpedicion(),
				norma.getFechaVigencia(),
				norma.getDeroga(),
				norma.getObservacion(),
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("entidadCodigo", norma.getEntidadCodigo());
			parameter.addValue("entidadExternaCodigo", norma.getEntidadExternaCodigo(), Types.INTEGER);
			parameter.addValue("rectoria", norma.getRectoria());
			parameter.addValue("cuerpoColegiadoCodigo", norma.getCuerpoColegiadoCodigo(), Types.INTEGER);
			parameter.addValue("normaTipoCodigo", norma.getNormaTipoCodigo());
			parameter.addValue("numero", norma.getNumero());
			parameter.addValue("nombre", norma.getNombre());
			parameter.addValue("url", norma.getUrl());
			parameter.addValue("medioCodigo", norma.getMedioCodigo());
			parameter.addValue("fechaExpedicion", norma.getFechaExpedicion());
			parameter.addValue("fechaVigencia", norma.getFechaVigencia(), Types.DATE);
			parameter.addValue("deroga", norma.getDeroga());
			parameter.addValue("observacion", norma.getObservacion());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
	}

	@Override
	public int actualizarNorma(Norma norma) {
		String sql = "UPDATE norma "
				+ "SET noe_codigo=?, ene_codigo=?, nor_rectoria=?, cuc_codigo=?, not_codigo=?, nor_numero=?, nor_nombre=?, nor_url=?, nom_codigo=?, nor_fecha_expedicion=?, nor_fecha_vigencia=?, nor_deroga=?, nor_observacion=?, nor_estado=? "
				+ "WHERE nor_codigo=?;";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				norma.getEntidadCodigo(),
				norma.getEntidadExternaCodigo(),
				norma.getRectoria(),
				norma.getCuerpoColegiadoCodigo(),
				norma.getNormaTipoCodigo(),
				norma.getNumero(),
				norma.getNombre(),
				norma.getUrl(),
				norma.getMedioCodigo(),
				norma.getFechaExpedicion(),
				norma.getFechaVigencia(),
				norma.getDeroga(),
				norma.getObservacion(),
				norma.getEstado(),
				norma.getCodigo()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("entidadCodigo", norma.getEntidadCodigo());
			parameter.addValue("entidadExternaCodigo", norma.getEntidadExternaCodigo(),Types.INTEGER);
			parameter.addValue("rectoria", norma.getRectoria());
			parameter.addValue("cuerpoColegiadoCodigo", norma.getCuerpoColegiadoCodigo(),Types.INTEGER);
			parameter.addValue("normaTipoCodigo", norma.getNormaTipoCodigo());
			parameter.addValue("numero", norma.getNumero());
			parameter.addValue("nombre", norma.getNombre());
			parameter.addValue("url", norma.getUrl());
			parameter.addValue("medioCodigo", norma.getMedioCodigo());
			parameter.addValue("fechaExpedicion", norma.getFechaExpedicion());
			parameter.addValue("fechaVigencia", norma.getFechaVigencia(), Types.DATE);
			parameter.addValue("deroga", norma.getDeroga());
			parameter.addValue("observacion", norma.getObservacion());
			parameter.addValue("estado", norma.getEstado());
			parameter.addValue("codigo", norma.getCodigo());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
	}
	
	@Override
	public int suspenderNorma(Norma norma) {
		
		String sql = "UPDATE norma "
				+ "SET nor_fecha_vigencia=? "
				+ "WHERE nor_codigo=?;";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				
				norma.getFechaVigencia(),
				norma.getCodigo()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("entidadCodigo", norma.getEntidadCodigo());
			parameter.addValue("entidadExternaCodigo", norma.getEntidadExternaCodigo(),Types.INTEGER);
			parameter.addValue("rectoria", norma.getRectoria());
			parameter.addValue("cuerpoColegiadoCodigo", norma.getCuerpoColegiadoCodigo(),Types.INTEGER);
			parameter.addValue("normaTipoCodigo", norma.getNormaTipoCodigo());
			parameter.addValue("numero", norma.getNumero());
			parameter.addValue("nombre", norma.getNombre());
			parameter.addValue("url", norma.getUrl());
			parameter.addValue("medioCodigo", norma.getMedioCodigo());
			parameter.addValue("fechaExpedicion", norma.getFechaExpedicion());
			parameter.addValue("fechaVigencia", norma.getFechaVigencia(), Types.DATE);
			parameter.addValue("deroga", norma.getDeroga());
			parameter.addValue("observacion", norma.getObservacion());
			parameter.addValue("estado", norma.getEstado());
			parameter.addValue("codigo", norma.getCodigo());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
		
	}
	
	//////////DEROGACIÓN

	@Override
	public List<NormaDeroga> obtenerNormaDerogada(int norma) {
		
		String sql = "select nd.nod_codigo, nd.nod_observacion, nd.nod_estado, dt.det_codigo, dt.det_nombre, nd.nor_codigo_padre, n.nor_nombre as nor_nombre_padre, nd.nor_codigo_hijo, nt2.not_nombre + ' ' + n2.nor_numero + ' ' + n2.nor_nombre as nor_nombre_hijo from norma_deroga nd "
				+ "inner join deroga_tipo dt on nd.det_codigo = dt.det_codigo "
				+ "left join norma n on nd.nor_codigo_padre  = n.nor_codigo "
				+ "inner join norma n2 on nd.nor_codigo_hijo = n2.nor_codigo "
				+ "left join norma_tipo nt2 on nt2.not_codigo = n2.not_codigo "
				+ "where nd.nod_estado = 1 and nd.nor_codigo_padre = " + norma;
		return jdbcTemplate.query(sql, new NormaDerogaSetExtractor());
		
	}

	@Override
	public int registrarNormaDeroga(NormaDeroga deroga) {
		
		String sql = "INSERT INTO norma_deroga "
				+ "(det_codigo, nor_codigo_padre, nor_codigo_hijo, nod_observacion) "
				+ "VALUES(?, ?, ?, ?);";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				deroga.getDerogaTipoCodigo(),
				deroga.getNormaPadreCodigo(),
				deroga.getNormaHijoCodigo(),
				deroga.getObservacion(),
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("derogaTipoCodigo", deroga.getDerogaTipoCodigo());
			parameter.addValue("normaPadreCodigo", deroga.getNormaPadreCodigo());
			parameter.addValue("normaHijoCodigo", deroga.getNormaHijoCodigo());
			parameter.addValue("observacion", deroga.getObservacion());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
		
	}

	@Override
	public int actualizarNormaDeroga(NormaDeroga deroga) {
		
		String sql = "UPDATE norma_deroga "
				+ "SET det_codigo=?, nor_codigo_padre=?, nor_codigo_hijo=?, nod_observacion=?, nod_estado=? "
				+ "WHERE nod_codigo=?;";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				deroga.getDerogaTipoCodigo(),
				deroga.getNormaPadreCodigo(),
				deroga.getNormaHijoCodigo(),
				deroga.getObservacion(),
				deroga.getEstado(),
				deroga.getCodigo()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("derogaTipoCodigo", deroga.getDerogaTipoCodigo());
			parameter.addValue("normaPadreCodigo", deroga.getNormaPadreCodigo());
			parameter.addValue("normaHijoCodigo", deroga.getNormaHijoCodigo());
			parameter.addValue("observacion", deroga.getObservacion());
			parameter.addValue("estado", deroga.getEstado());
			parameter.addValue("codigo", deroga.getCodigo());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
		
	}
	
/////CLASIFICACION
	
	@Override
	public List<NormaGrupo> obtenerNormaGrupos() {
		
		String sql = "select * from norma_grupo ng where ng.nog_estado = 1 order by ng.nog_codigo ";
		return jdbcTemplate.query(sql, new NormaGrupoSetExtractor());
		
	}

	@Override
	public List<Norma> obtenerNormaSinClasificar(int normaGrupoCodigo) {
		
		String sql = "SELECT *, nt2.not_nombre + ' ' + n2.nor_numero + ' ' + n2.nor_nombre as deroga_padre FROM norma n "
				+ "inner join norma_entidad ne on n.noe_codigo = ne.noe_codigo "
				+ "inner join norma_tipo nt on n.not_codigo = nt.not_codigo "
				+ "inner join norma_medio nm on n.nom_codigo = nm.nom_codigo "
				+ "left join cuerpos_colegiados cc on n.cuc_codigo = cc.cuc_codigo "
				+ "left join entidad_externa ee on n.ene_codigo = ee.ene_codigo "
				+ "left join norma_deroga nd on n.nor_codigo = nd.nor_codigo_hijo and nd.nod_estado = 1 "
				+ "left join norma n2 on nd.nor_codigo_padre = n2.nor_codigo "
				+ "left join norma_tipo nt2 on nt2.not_codigo = n2.not_codigo "
				+ "WHERE n.nor_estado = 1 and NOT EXISTS ( SELECT * FROM norma_clasificada nc WHERE n.nor_codigo = nc.nor_codigo and nc.noc_estado != 0 and nc.nog_codigo = " + normaGrupoCodigo + ");";
		return jdbcTemplate.query(sql, new NormaSetExtractor());
		
	}

	@Override
	public List<NormaClasificacion> obtenerNormaClasificada(int normaGrupoCodigo) {
		
		String sql = "select *, nt2.not_nombre + ' ' + n2.nor_numero + ' ' + n2.nor_nombre as deroga_padre from norma_clasificada nc "
				+ "inner join norma n on nc.nor_codigo = n.nor_codigo "
				+ "inner join norma_entidad ne on n.noe_codigo = ne.noe_codigo "
				+ "inner join norma_grupo ng on nc.nog_codigo = ng.nog_codigo "
				+ "inner join norma_tipo nt on n.not_codigo = nt.not_codigo "
				+ "inner join norma_medio nm on n.nom_codigo = nm.nom_codigo "
				+ "left join cuerpos_colegiados cc on n.cuc_codigo = cc.cuc_codigo "
				+ "left join entidad_externa ee on n.ene_codigo = ee.ene_codigo "
				+ "left join norma_deroga nd on n.nor_codigo = nd.nor_codigo_hijo and nd.nod_estado = 1 "
				+ "left join norma n2 on nd.nor_codigo_padre = n2.nor_codigo "
				+ "left join norma_tipo nt2 on nt2.not_codigo = n2.not_codigo "
				+ "where nc.noc_estado = 1 and nc.nog_codigo = " + normaGrupoCodigo;
		return jdbcTemplate.query(sql, new NormaClasificacionSetExtractor());
		
	}

	@Override
	public int registrarNormaClasificada(NormaClasificacion normaClasificacion) {
		
		String sql = "INSERT INTO norma_clasificada "
				+ "(nor_codigo, nog_codigo) "
				+ "VALUES(?, ?);";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				normaClasificacion.getNorma().getCodigo(),
				normaClasificacion.getNormaGrupo().getCodigo(),
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("normaCodigo", normaClasificacion.getNorma().getCodigo());
			parameter.addValue("normaGrupoCodigo", normaClasificacion.getNormaGrupo().getCodigo());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
		
	}

	@Override
	public int actualizarNormaClasificada(NormaClasificacion normaClasificacion) {
		
		String sql = "UPDATE norma_clasificada "
				+ "SET noc_estado=? "
				+ "WHERE noc_codigo=?;";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				normaClasificacion.getEstado(),
				normaClasificacion.getCodigo()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("estado", normaClasificacion.getEstado());
			parameter.addValue("codigo", normaClasificacion.getCodigo());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
	}

	@Override
	public List<NormaGrupo> obtenerNormaGruposAgrupados() {
		
		String sql = "select ng.nog_codigo, ng.nog_nombre, count(nc.nor_codigo) as nog_cantidad, ng.nog_estado from norma_grupo ng "
				+ "left join norma_clasificada nc on ng.nog_codigo = nc.nog_codigo and nc.noc_estado = 1 "
				+ "where ng.nog_estado = 1 "
				+ "group by ng.nog_codigo ,ng.nog_nombre, ng.nog_estado ";
		return jdbcTemplate.query(sql, new NormaGrupoCantidadSetExtractor());
		
	}

	@Override
	public int registrarNormaGrupo(NormaGrupo normaGrupo) {
		
		String sql = "INSERT INTO norma_grupo "
				+ "(nog_nombre) "
				+ "VALUES(?);";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				normaGrupo.getNombre(),
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("nombre", normaGrupo.getNombre());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
		
	}

	@Override
	public int actualizarNormaGrupo(NormaGrupo normaGrupo) {
		
		String sql = "UPDATE norma_grupo "
				+ "SET nog_nombre=?, nog_estado=? "
				+ "WHERE nog_codigo=?;";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				normaGrupo.getNombre(),
				normaGrupo.getEstado(),
				normaGrupo.getCodigo()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("nombre", normaGrupo.getNombre());
			parameter.addValue("estado", normaGrupo.getEstado());
			parameter.addValue("codigo", normaGrupo.getCodigo());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
		
	}

}
