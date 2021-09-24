package com.softbank.consulta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softbank.consulta.model.Login;
import com.softbank.consulta.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	public List<Login> findAll() {
		return loginRepository.findAll();
	}
}
