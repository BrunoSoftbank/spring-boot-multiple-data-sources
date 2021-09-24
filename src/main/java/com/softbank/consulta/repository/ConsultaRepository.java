package com.softbank.consulta.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softbank.consulta.mapper.ConsultaMapper;
import com.softbank.consulta.model.Consulta;

@Repository
public class ConsultaRepository {
	
	public static final String QUERY = "SELECT id, usuario_id, exame_id, laboratorio_id FROM consulta";
	
	@Autowired
    @Qualifier("consultaDataSourceJDBC")
    private JdbcTemplate jdbcTemplateInsurance;

	public List<Consulta> findAll() {
		return jdbcTemplateInsurance.query(QUERY, new ConsultaMapper());
	}

}
