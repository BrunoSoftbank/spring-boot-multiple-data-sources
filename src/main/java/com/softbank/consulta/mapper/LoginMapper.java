package com.softbank.consulta.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.softbank.consulta.model.Login;

public class LoginMapper implements RowMapper<Login> {

	@Override
	public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
		Login login = new Login();
		login.setId(rs.getLong("id"));
		login.setNome(rs.getString("nome"));
		return login;
	}

}
