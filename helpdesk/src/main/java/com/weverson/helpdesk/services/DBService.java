package com.weverson.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import com.weverson.helpdesk.HelpdeskApplication;
import com.weverson.helpdesk.domain.Chamado;
import com.weverson.helpdesk.domain.Cliente;
import com.weverson.helpdesk.domain.Tecnico;
import com.weverson.helpdesk.domain.enums.Perfil;
import com.weverson.helpdesk.domain.enums.Prioridade;
import com.weverson.helpdesk.domain.enums.Status;
import com.weverson.helpdesk.repositories.ChamadoRepository;
import com.weverson.helpdesk.repositories.ClienteRepository;
import com.weverson.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	public void instanciaDB() {
		Tecnico t1 = new Tecnico(null,"Valdir Cesar","111111111110","valdi@mail.com","123");
		t1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null,"Linux Torvalds","111111111110","torvalds@mail.com","123");
	
		Chamado c1 = new Chamado(null,Prioridade.MEDIA, Status.ANDAMENTO,"Chamado 01","Primeiro Chamado",t1,cli1);
	
		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}

}
