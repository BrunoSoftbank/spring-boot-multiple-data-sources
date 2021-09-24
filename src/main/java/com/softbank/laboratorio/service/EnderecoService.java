package com.softbank.laboratorio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softbank.laboratorio.model.Endereco;
import com.softbank.laboratorio.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Endereco> findAll() {
		return enderecoRepository.findAll();
	}
}
