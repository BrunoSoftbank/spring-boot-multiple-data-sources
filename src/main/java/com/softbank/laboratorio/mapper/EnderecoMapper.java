package com.softbank.laboratorio.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.softbank.laboratorio.model.Endereco;

public class EnderecoMapper implements RowMapper<Endereco> {

	@Override
	public Endereco mapRow(ResultSet rs, int rowNum) throws SQLException {
		Endereco endereco = new Endereco();
		endereco.setId(rs.getLong("id"));
		endereco.setBairro(rs.getString("bairro"));
		endereco.setCidade(rs.getString("cidade"));
		endereco.setNumero(rs.getString("numero"));
		endereco.setRua(rs.getString("rua"));
		return endereco;
	}

}
