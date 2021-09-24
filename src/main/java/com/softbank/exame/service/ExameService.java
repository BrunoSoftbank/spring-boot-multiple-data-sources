package com.softbank.exame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softbank.exame.model.Exame;
import com.softbank.exame.repository.ExameRepository;

@Service
public class ExameService {
	
	@Autowired
	private ExameRepository weatherRepository;

	public List<Exame> findAll() {
		return weatherRepository.findAll();
	}
}
