package com.softbank.consulta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {
	
	private Long id;
	private Long usuarioId;
	private Long exameId;
	private Long laboratorioId;

}
