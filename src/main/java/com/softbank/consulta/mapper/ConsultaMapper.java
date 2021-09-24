package com.softbank.consulta.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.softbank.consulta.model.Consulta;

public class ConsultaMapper implements RowMapper<Consulta> {

	@Override
	public Consulta mapRow(ResultSet rs, int rowNum) throws SQLException {
		Consulta consulta = new Consulta();
		consulta.setId(rs.getLong("id"));
		consulta.setUsuarioId(rs.getLong("usuario_id"));
		consulta.setExameId(rs.getLong("exame_id"));
		consulta.setLaboratorioId(rs.getLong("laboratorio_id"));
		return consulta;
	}
}
