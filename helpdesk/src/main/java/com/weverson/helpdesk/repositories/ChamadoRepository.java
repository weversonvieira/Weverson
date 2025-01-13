package com.weverson.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weverson.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

}
