package com.softbank.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softbank.usuario.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
