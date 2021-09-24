package com.softbank.laboratorio.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softbank.laboratorio.mapper.EnderecoMapper;
import com.softbank.laboratorio.model.Endereco;

@Repository
public class EnderecoRepository {

public static final String QUERY = "SELECT id, bairro, cidade, numero, rua FROM endereco";
	
	@Autowired
    @Qualifier("laboratorioDataSourceJDBC")
    private JdbcTemplate jdbcTemplateInsurance;

	public List<Endereco> findAll() {
		return jdbcTemplateInsurance.query(QUERY, new EnderecoMapper());
	}
}
