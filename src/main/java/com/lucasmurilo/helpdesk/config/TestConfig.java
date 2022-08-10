package com.lucasmurilo.helpdesk.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucasmurilo.helpdesk.domain.Chamado;
import com.lucasmurilo.helpdesk.domain.Cliente;
import com.lucasmurilo.helpdesk.domain.Tecnico;
import com.lucasmurilo.helpdesk.enums.Perfil;
import com.lucasmurilo.helpdesk.enums.Prioridade;
import com.lucasmurilo.helpdesk.enums.Status;
import com.lucasmurilo.helpdesk.repositories.ChamadoRepository;
import com.lucasmurilo.helpdesk.repositories.ClienteRepository;
import com.lucasmurilo.helpdesk.repositories.TecnicoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Tecnico tec1 = new Tecnico(null, "Lucas Murilo", "02308639148", "lucasmurilo.guedes@gmail.com", "12345");
		tec1.addPerfis(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Maria Brasileira", "123464678912", "maria@gmail.com", "123456");
		
		Chamado chamado1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, 
				"Chamado 01", "Primeiro chamado", tec1, cli1);
		
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(chamado1));
	}

}
