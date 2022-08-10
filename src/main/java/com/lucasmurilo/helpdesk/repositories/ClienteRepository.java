package com.lucasmurilo.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasmurilo.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente , Integer> {

}
