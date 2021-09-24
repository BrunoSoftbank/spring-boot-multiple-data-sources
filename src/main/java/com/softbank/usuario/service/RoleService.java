package com.softbank.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softbank.usuario.model.Role;
import com.softbank.usuario.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> findAll() {
		return roleRepository.findAll();
	}
}
