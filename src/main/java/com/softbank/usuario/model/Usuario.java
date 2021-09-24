package com.softbank.usuario.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
@Table(name = "usuario")
@Entity
public class Usuario {
	
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String email;
    
} 
