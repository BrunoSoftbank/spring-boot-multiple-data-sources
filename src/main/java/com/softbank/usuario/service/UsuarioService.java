package com.softbank.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softbank.usuario.model.Usuario;
import com.softbank.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository weatherRepository;

	public List<Usuario> findAll() {
		return weatherRepository.findAll();
	}
}
