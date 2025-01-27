package com.weverson.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weverson.helpdesk.domain.Chamado;
import com.weverson.helpdesk.domain.Cliente;
import com.weverson.helpdesk.domain.Tecnico;
import com.weverson.helpdesk.domain.enums.Perfil;
import com.weverson.helpdesk.domain.enums.Prioridade;
import com.weverson.helpdesk.domain.enums.Status;
import com.weverson.helpdesk.repositories.ChamadoRepository;
import com.weverson.helpdesk.repositories.ClienteRepository;
import com.weverson.helpdesk.repositories.PessoaRepository;
import com.weverson.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	public void instanciaDB() {
		Tecnico t1 = new Tecnico();
		t1.addPerfil(Perfil.ADMIN);
		t1.setNome("Valdir Cesar");
		t1.setCpf("70074459007");
		t1.setEmail("valdi@mail.com");
		t1.setSenha("123");

		Tecnico t2 = new Tecnico();
		t2.setNome("Jurandir Vieira");
		t2.setCpf("26216697005");
		t2.setEmail("jurandir@mail.com");
		t2.setSenha("123");

		Tecnico t3 = new Tecnico();
		t3.setNome("Valdir Pereira");
		t3.setCpf("66119078070");
		t3.setEmail("pereira@mail.com");
		t3.setSenha("123");

		Tecnico t4 = new Tecnico();
		t4.setNome("Caio Cesar");
		t4.setCpf("66465080036");
		t4.setEmail("caio@mail.com");
		t4.setSenha("123");

		Tecnico t5 = new Tecnico();
		t5.setNome("Luan");
		t5.setCpf("04000026046");
		t5.setEmail("luan@mail.com");
		t5.setSenha("123");

		Cliente cli1 = new Cliente();
		cli1.setNome("Linux Torvalds");
		cli1.setCpf("75461460038");
		cli1.setEmail("torvalds@mail.com");
		cli1.setSenha("123");

		Cliente cli2 = new Cliente();
		cli2.setNome("Paulo Cissé");
		cli2.setCpf("26889102053");
		cli2.setEmail("paulo@mail.com");
		cli2.setSenha("123");

		Cliente cli3 = new Cliente();
		cli3.setNome("Ake Traore");
		cli3.setCpf("38565805069");
		cli3.setEmail("ake@mail.com");
		cli3.setSenha("123");

		Cliente cli4 = new Cliente();
		cli4.setNome("Diddier Drogba");
		cli4.setCpf("76010980011");
		cli4.setEmail("diddier@mail.com");
		cli4.setSenha("123");

		Cliente cli5 = new Cliente();
		cli5.setNome("Thuram Marcus");
		cli5.setCpf("10295514051");
		cli5.setEmail("thuram@mail.com");
		cli5.setSenha("123");
		
		Chamado c1 = new Chamado();
		c1.setCliente(cli1);
		c1.setPrioridade(Prioridade.MEDIA);
		c1.setStatus(Status.ANDAMENTO);
		c1.setTitulo("Chamado 1");
		c1.setObservacoes("primeiro chamado");
		c1.setTecnico(t1);
		// pessoaRepository.saveAll(Arrays.asList(t1,t2,t3,t4,t5,cli1,cli2,cli3,cli4,cli5));

		pessoaRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5, cli1, cli2, cli3, cli4, cli5));

		chamadoRepository.saveAll(Arrays.asList(c1));
	}

}
