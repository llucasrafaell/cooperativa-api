package com.projeto.coperativa.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.projeto.coperativa.Associado;

public class AssociadoDto {
	
	private Long id;
	private String nome;
	private String cpf;
	
	public AssociadoDto (Associado associado){ 
		this.nome = associado.getNome();
		this.id = associado.getId();
		this.cpf = associado.getCpf();
	}

	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static List<AssociadoDto> converter(List<Associado> associado) {
	    return associado.stream().map(AssociadoDto::new).collect(Collectors.toList());
	        }
}
