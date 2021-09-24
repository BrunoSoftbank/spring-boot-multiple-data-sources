package com.softbank.laboratorio.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softbank.laboratorio.mapper.LaboratorioMapper;
import com.softbank.laboratorio.model.Laboratorio;

@Repository
public class LaboratorioRepository {

	public static final String QUERY = "SELECT id, nome FROM laboratorio";
	
	@Autowired
    @Qualifier("laboratorioDataSourceJDBC")
    private JdbcTemplate jdbcTemplateInsurance;

	public List<Laboratorio> findAll() {
		return jdbcTemplateInsurance.query(QUERY, new LaboratorioMapper());
	}
}
