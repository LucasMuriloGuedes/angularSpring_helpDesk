package com.lucasmurilo.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasmurilo.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{

}
