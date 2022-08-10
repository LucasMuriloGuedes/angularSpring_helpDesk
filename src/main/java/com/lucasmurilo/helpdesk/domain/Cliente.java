package com.lucasmurilo.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lucasmurilo.helpdesk.domain.dtos.ClienteDTO;
import com.lucasmurilo.helpdesk.enums.Perfil;

@Entity
public class Cliente extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "cliente")
	@JsonIgnore
	private List<Chamado> chamados = new ArrayList<>();

	public Cliente() {
		super();
		
		addPerfis(Perfil.CLIENTE);
	}

	public Cliente(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
	}

	public List<Chamado> getChamados() {
		return chamados;
	}
	
	public Cliente(ClienteDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.datacriacao = obj.getDatacriacao();

	}
	
}
