package com.weverson.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weverson.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
