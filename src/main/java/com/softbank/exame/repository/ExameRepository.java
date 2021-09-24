package com.softbank.exame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softbank.exame.model.Exame;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Integer> {

}
