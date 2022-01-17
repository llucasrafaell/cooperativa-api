package com.projeto.coperativa.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.projeto.coperativa.Associado;
import com.projeto.coperativa.repository.AssociadoRepository;

public class AssociadoForm {

	@NotNull @NotEmpty @Length(min=3)
	private String nome;
	private String cpf;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}

	public Associado converter(AssociadoRepository associadoRepository) {
		
		return new Associado(nome, cpf);
	}
	
}
