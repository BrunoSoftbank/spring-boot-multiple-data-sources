package com.softbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.softbank.consulta.service.ConsultaService;
import com.softbank.consulta.service.LoginService;
import com.softbank.exame.service.ExameService;
import com.softbank.laboratorio.service.EnderecoService;
import com.softbank.laboratorio.service.LaboratorioService;
import com.softbank.usuario.service.RoleService;
import com.softbank.usuario.service.UsuarioService;

@SpringBootApplication
public class MultipleDataBaseApplication implements CommandLineRunner {
	
	@Autowired
	private ExameService exameService;
	@Autowired
	private UsuarioService sportService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private LaboratorioService laboratorioService;
	@Autowired
	private ConsultaService consultaService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private EnderecoService enderecoService;


	public static void main(String[] args) {
		SpringApplication.run(MultipleDataBaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Banco de dados MONGO DB via JPA");
		System.out.println("Tabela Exame");
		exameService.findAll().forEach(exame -> System.out.println(exame));
		
		System.out.println("-------------------------------------");
		
		System.out.println("Banco de dados My Sql via JPA");
		System.out.println("Tabela Usuario");
		sportService.findAll().forEach(usuario -> System.out.println(usuario));
		System.out.println("Tabela Role");
		roleService.findAll().forEach(role -> System.out.println(role));
		
		System.out.println("-------------------------------------");
		
		System.out.println("Banco de dados Postgresql via JPA");
		System.out.println("Tabela Laboratorio");
		laboratorioService.findAll().forEach(laboratorio -> System.out.println(laboratorio));
		System.out.println("Tabela Endereco");
		enderecoService.findAll().forEach(endereco -> System.out.println(endereco));
		
		System.out.println("-------------------------------------");
		
		System.out.println("Banco de dados CONSULTA via JDBC");
		System.out.println("Tabela Consulta");
		consultaService.findAll().forEach(consulta -> System.out.println(consulta));
		System.out.println("Tabela Login");
		loginService.findAll().forEach(login -> System.out.println(login));
	}
}
