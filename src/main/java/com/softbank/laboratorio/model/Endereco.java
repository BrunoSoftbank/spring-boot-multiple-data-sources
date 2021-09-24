package com.softbank.laboratorio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

	private Long id;
	private String bairro;
	private String cidade;
	private String numero;
	private String rua;
}
