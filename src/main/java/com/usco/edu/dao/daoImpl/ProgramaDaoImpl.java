package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IProgramaDao;
import com.usco.edu.entities.AreaConocimiento;
import com.usco.edu.entities.Nbc;
import com.usco.edu.entities.NivelFormacion;
import com.usco.edu.entities.Programa;
import com.usco.edu.resultSetExtractor.AreaConocimientoSetExtractor;
import com.usco.edu.resultSetExtractor.NbcSetExtractor;
import com.usco.edu.resultSetExtractor.NivelFormacionSetExtractor;
import com.usco.edu.resultSetExtractor.ProgramaSetExtractor;

@Repository
public class ProgramaDaoImpl implements IProgramaDao{
	
	@Autowired
	@Qualifier("JDBCTemplateUscoEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;
	
	@Autowired
	@Qualifier("JDBCTemplateUscoConsulta")
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Programa> obtenerListadoProgramas() {
		String sql = "select * from programa p "
				+ "inner join estado_snies es on p.ess_codigo = es.ess_codigo "
				+ "inner join ciclo_propedeutico cp on p.cip_codigo = cp.cip_codigo "
				+ "inner join nivel_formacion nf on p.nif_codigo = nf.nif_codigo "
				+ "inner join nivel_academico na on nf.nia_codigo = na.nia_codigo " 
				+ "inner join modalidad m on p.mod_codigo = m.mod_codigo "
				+ "inner join nbc n on p.nbc_codigo = n.nbc_codigo "
				+ "inner join area_conocimiento ac on n.arc_codigo = ac.arc_codigo " 
				+ "inner join facultad f on p.fac_codigo = f.fac_codigo "
				+ "inner join sede s on f.sed_codigo = s.sed_codigo "
				+ "inner join sede_tipo st on s.set_tipo = st.set_codigo "
				+ "inner join cabeceras_centros_poblados ccp on s.ccp_divipola = ccp.ccp_divipola "
				+ "inner join municipio m2 on ccp.mun_divipola = m2.mun_divipola "
				+ "inner join departamento d on m2.dep_divipola = d.dep_divipola "
				+ "inner join pais p2 on d.pai_codigo = p2.pai_codigo "
				+ "inner join tiempo_duracion td on p.tid_codigo = td.tid_codigo "
				+ "inner join tiempo_admision ta on p.tia_codigo = ta.tia_codigo "
				+ "inner join norma nr on p.nor_codigo = nr.nor_codigo "
				+ "inner join norma_tipo nt on nr.not_codigo = nt.not_codigo "
				+ "inner join campo_detallado_cine cdc on p.cdc_codigo = cdc.cdc_codigo "
				+ "inner join campo_especifico_cine cec on cdc.cec_codigo = cec.cec_codigo "
				+ "inner join campo_amplio_cine cac on cec.cac_codigo = cac.cac_codigo "
				+ "where p.pro_estado = 1";
		return jdbcTemplate.query(sql, new ProgramaSetExtractor());
	}
	
	@Override
	public List<NivelFormacion> obtenerListadoNivelesFormacion() {
		String sql = "select * from nivel_formacion nf "
				+ "inner join nivel_academico na on nf.nia_codigo = na.nia_codigo "
				+ "where nf.nif_estado = 1";
		return jdbcTemplate.query(sql, new NivelFormacionSetExtractor());
	}

	@Override
	public List<NivelFormacion> obtenerListadoNivelFormacion(int nivelAcademicoCodigo) {
		
		String sql = "select * from nivel_formacion nf "
				+ "inner join nivel_academico na on nf.nia_codigo = na.nia_codigo "
				+ "where nf.nia_codigo = " + nivelAcademicoCodigo;
		return jdbcTemplate.query(sql, new NivelFormacionSetExtractor());
		
	}

	@Override
	public List<AreaConocimiento> obtenerListadoAreaConocimiento() {
		
		String sql = "select * from area_conocimiento ac where ac.arc_estado = 1 ";
		return jdbcTemplate.query(sql, new AreaConocimientoSetExtractor());
		
	}

	@Override
	public List<Nbc> obtenerListadoNbc(int areaConocimientoCodigo) {
		
		String sql = "select * from nbc n "
				+ "inner join area_conocimiento ac on n.arc_codigo = ac.arc_codigo "
				+ "where n.arc_codigo = " + areaConocimientoCodigo;
		return jdbcTemplate.query(sql, new NbcSetExtractor());
		
	}

	@Override
	public int registrarPrograma(Programa programa) {
		
		String sql = "INSERT INTO programa "
				+ "(pro_codigo_snies, ess_codigo, cip_codigo, nif_codigo, mod_codigo, nbc_codigo, fac_codigo, pro_nombre, pro_titulo_otorgado, "
				+ "pro_numero_creditos, tid_codigo, pro_duracion, tia_codigo, pro_numero_cupos, pro_sitio_web, nor_codigo, pro_convenio, cdc_codigo, "
				+ "pro_fecha_creacion, pro_fecha_registro_snies) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				programa.getSnies(),
				programa.getEstadoSniesCodigo(),
				programa.getCiclosCodigo(),
				programa.getNivelFormacionCodigo(),
				programa.getModalidadCodigo(),
				programa.getNbcCodigo(),
				programa.getFacultad().getCodigo(),
				programa.getNombre(),
				programa.getTitulo(),
				programa.getCreditos(),
				programa.getTipoDuracionCodigo(),
				programa.getDuracion(),
				programa.getTipoAdmisionCodigo(),
				programa.getCupos(),
				programa.getSitioWeb(),
				programa.getNormaCodigo(),
				programa.getConvenio(),
				programa.getCampoDetallado().getCodigo(),
				programa.getFechaCreacion(),
				programa.getFechaRegistroSnies(),

				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("snies", programa.getSnies());
			parameter.addValue("estadoSnies", programa.getEstadoSniesCodigo());
			parameter.addValue("ciclos", programa.getCiclosCodigo());
			parameter.addValue("nivelFormacion", programa.getNivelFormacionCodigo());
			parameter.addValue("modalidad", programa.getModalidadCodigo());
			parameter.addValue("nbc", programa.getNbcCodigo());
			parameter.addValue("facultad", programa.getFacultad().getCodigo());
			parameter.addValue("nombre", programa.getNombre());
		    parameter.addValue("titulo", programa.getTitulo());
		    parameter.addValue("creditos", programa.getCreditos());
		    parameter.addValue("tipoDuracion", programa.getTipoDuracionCodigo());
		    parameter.addValue("duracion", programa.getDuracion());
		    parameter.addValue("tipoAdmision", programa.getTipoAdmisionCodigo());
		    parameter.addValue("cupos", programa.getCupos());
		    parameter.addValue("sitioWeb", programa.getSitioWeb());
		    parameter.addValue("normaCodigo", programa.getNormaCodigo());
		    parameter.addValue("convenio", programa.getConvenio());
		    parameter.addValue("campoDetallado", programa.getCampoDetallado().getCodigo());
		    parameter.addValue("fechaCreacion", programa.getFechaCreacion());
		    parameter.addValue("fechaRegistroSnies", programa.getFechaRegistroSnies());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
	}

	@Override
	public int actualizarPrograma(Programa programa) {
		
		String sql = "UPDATE programa "
				+ "SET pro_codigo_snies=?, ess_codigo =?, cip_codigo=?, nif_codigo=?, mod_codigo=?, nbc_codigo=?, fac_codigo=?, pro_nombre=?, pro_titulo_otorgado=?, "
				+ "pro_numero_creditos=?, tid_codigo=?, pro_duracion=?, tia_codigo=?, pro_numero_cupos=?, pro_sitio_web=?, nor_codigo=?, pro_convenio=?, "
				+ "cdc_codigo=?, pro_fecha_creacion=?, pro_fecha_registro_snies=?, pro_estado=? "
				+ "WHERE pro_codigo=?;";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				programa.getSnies(),
				programa.getEstadoSniesCodigo(),
				programa.getCiclosCodigo(),
				programa.getNivelFormacionCodigo(),
				programa.getModalidadCodigo(),
				programa.getNbcCodigo(),
				programa.getFacultad().getCodigo(),
				programa.getNombre(),
				programa.getTitulo(),
				programa.getCreditos(),
				programa.getTipoDuracionCodigo(),
				programa.getDuracion(),
				programa.getTipoAdmisionCodigo(),
				programa.getCupos(),
				programa.getSitioWeb(),
				programa.getNormaCodigo(),
				programa.getConvenio(),
				programa.getCampoDetallado().getCodigo(),
				programa.getFechaCreacion(),
				programa.getFechaRegistroSnies(),
				programa.getEstado(),
				programa.getCodigo(),

				});

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("snies", programa.getSnies());
			parameter.addValue("estadoSnies", programa.getEstadoSniesCodigo());
			parameter.addValue("ciclos", programa.getCiclosCodigo());
			parameter.addValue("nivelFormacion", programa.getNivelFormacionCodigo());
			parameter.addValue("modalidad", programa.getModalidadCodigo());
			parameter.addValue("nbc", programa.getNbcCodigo());
			parameter.addValue("facultad", programa.getFacultad().getCodigo());
			parameter.addValue("nombre", programa.getNombre());
		    parameter.addValue("titulo", programa.getTitulo());
		    parameter.addValue("creditos", programa.getCreditos());
		    parameter.addValue("tipoDuracion", programa.getTipoDuracionCodigo());
		    parameter.addValue("duracion", programa.getDuracion());
		    parameter.addValue("tipoAdmision", programa.getTipoAdmisionCodigo());
		    parameter.addValue("cupos", programa.getCupos());
		    parameter.addValue("sitioWeb", programa.getSitioWeb());
		    parameter.addValue("normaCodigo", programa.getNormaCodigo());
		    parameter.addValue("convenio", programa.getConvenio());
		    parameter.addValue("campoDetallado", programa.getCampoDetallado().getCodigo());
		    parameter.addValue("fechaCreacion", programa.getFechaCreacion());
		    parameter.addValue("fechaRegistroSnies", programa.getFechaRegistroSnies());
		    parameter.addValue("estado", programa.getEstado());
		    parameter.addValue("codigo", programa.getCodigo());

			return result;
			
		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
	}
}
