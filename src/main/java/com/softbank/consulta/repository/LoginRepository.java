package com.softbank.consulta.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softbank.consulta.mapper.LoginMapper;
import com.softbank.consulta.model.Login;

@Repository
public class LoginRepository {

public static final String QUERY = "SELECT id, nome FROM login";
	
	@Autowired
    @Qualifier("consultaDataSourceJDBC")
    private JdbcTemplate jdbcTemplateInsurance;

	public List<Login> findAll() {
		return jdbcTemplateInsurance.query(QUERY, new LoginMapper());
	}
}
