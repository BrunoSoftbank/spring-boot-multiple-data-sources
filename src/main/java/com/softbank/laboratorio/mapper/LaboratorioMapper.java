package com.softbank.laboratorio.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.softbank.laboratorio.model.Laboratorio;

public class LaboratorioMapper implements RowMapper<Laboratorio> {

	@Override
	public Laboratorio mapRow(ResultSet rs, int rowNum) throws SQLException {
		Laboratorio laboratorio = new Laboratorio();
		laboratorio.setId(rs.getLong("id"));
		laboratorio.setNome(rs.getString("nome"));
		return laboratorio;
	}

}