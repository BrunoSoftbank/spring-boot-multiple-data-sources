package com.softbank.laboratorio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softbank.laboratorio.model.Laboratorio;
import com.softbank.laboratorio.repository.LaboratorioRepository;

@Service
public class LaboratorioService {

	@Autowired
	private LaboratorioRepository laboratorioRepository;
	
	public List<Laboratorio> findAll() {
		return laboratorioRepository.findAll();
	}
}
