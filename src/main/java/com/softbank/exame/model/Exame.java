package com.softbank.exame.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
@Document
public class Exame {
	
	@Id
	private String id;
	private String nome;
	private String descricao;
    
} 
