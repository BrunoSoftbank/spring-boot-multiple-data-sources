package com.softbank.exame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softbank.exame.model.Tipo;
import com.softbank.exame.repository.TipoRepository;

@Service
public class TipoService {

	@Autowired
	private TipoRepository tipoRepository;
	
	public List<Tipo> findAll() {
		return tipoRepository.findAll();
	}
}
