package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IGraduadoDao;
import com.usco.edu.entities.Graduado;
import com.usco.edu.resultSetExtractor.GraduadoSetExtractor;

@Repository
public class GraduadoDaoImpl implements IGraduadoDao{
	
	@Autowired
	@Qualifier("JDBCTemplatePlanesConsulta")
	public JdbcTemplate jdbcTemplate;
	

	@Override
	public List<Graduado> buscarPorCodigo(String codigo, String userdb) {

		String sql = "Select top 1 *, floor((cast(convert(varchar(8),getdate(),112) as int) - cast(convert(varchar(8), p.per_fecha_nacimiento ,112) as int) ) / 10000) as edad from graduado g "
				+ "inner join estudiante e on g.est_codigo = e.est_codigo "
				+ "inner join persona p on e.per_codigo = p.per_codigo "
				+ "inner join grupo_sanguineo gs on p.grs_codigo = gs.grs_codigo "
				+ "inner join tipo_id ti on p.tii_codigo = ti.tii_codigo "
				+ "inner join programa pr on e.pro_codigo = pr.pro_codigo "
				+ "inner join uaa u on pr.uaa_codigo = u.uaa_codigo "
				+ "inner join sede s on pr.sed_codigo = s.sed_codigo "
				+ "where p.per_identificacion  = '" + codigo + "' order by g.gra_codigo desc";
		return jdbcTemplate.query(sql, new GraduadoSetExtractor());
	}

}
