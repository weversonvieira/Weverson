package com.weverson.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weverson.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{

}
