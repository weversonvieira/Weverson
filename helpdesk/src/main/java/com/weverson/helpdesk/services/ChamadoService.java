package com.weverson.helpdesk.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weverson.helpdesk.domain.Chamado;
import com.weverson.helpdesk.domain.Cliente;
import com.weverson.helpdesk.domain.Tecnico;
import com.weverson.helpdesk.domain.dtos.ChamadoDTO;
import com.weverson.helpdesk.domain.enums.Prioridade;
import com.weverson.helpdesk.domain.enums.Status;
import com.weverson.helpdesk.repositories.ChamadoRepository;
import com.weverson.helpdesk.services.exception.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ClienteService clienteService;

	public Chamado findById(Integer id) {
		Optional<Chamado> obj = chamadoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ID: " + id));
	}

	public List<Chamado> findAll() {

		return chamadoRepository.findAll();
	}
	
	public Chamado create(@Valid ChamadoDTO chamadoDTO) {
		
		return chamadoRepository.save(newChamado(chamadoDTO));
	}
	
	private Chamado newChamado(ChamadoDTO chamadoDTO) {
		
		Tecnico tecnico = tecnicoService.findById(chamadoDTO.getTecnico());
		Cliente cliente = clienteService.findById(chamadoDTO.getCliente());
		Chamado chamado = new Chamado();
		if(chamadoDTO.getId() != null) {
			chamado.setId(chamadoDTO.getId());
		}
		
		if(chamadoDTO.getStatus().equals(2)) {
			chamado.setDataFechamento(LocalDate.now());
		}
		chamado.setCliente(cliente);
		chamado.setTecnico(tecnico);
		chamado.setPrioridade(Prioridade.toEnum(chamadoDTO.getPrioridade()));
		chamado.setStatus(Status.toEnum(chamadoDTO.getStatus()));
		chamado.setTitulo(chamadoDTO.getTitulo());
		chamado.setObservacoes(chamadoDTO.getObservacoes());
		return chamado;
	}
	
	public Chamado update(Integer id, @Valid ChamadoDTO chamadoDTO) {
		chamadoDTO.setId(id);
		
		Chamado oldObj = findById(id);
		oldObj = newChamado(chamadoDTO);
		return chamadoRepository.save(oldObj);
		
	}

}
