package com.softbank.consulta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softbank.consulta.model.Consulta;
import com.softbank.consulta.repository.ConsultaRepository;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository consultaRepository;
	
	public List<Consulta> findAll() {
		return consultaRepository.findAll();
	}
}
