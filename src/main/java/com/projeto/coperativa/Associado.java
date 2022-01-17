package com.projeto.coperativa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.Validator;

@Entity
public class Associado {
	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String cpf;
	

	
	public Associado() {
	}
	
	public Associado(String nome, String cpf ) {
		this.nome = nome;
		this.cpf = cpf;
		
		try {
			validadorDocumentos(new CPFValidator(), cpf);
			System.out.println("CPF VÁLIDO");
	  } catch (InvalidStateException e) {
			System.out.println("CPF INVÁLIDO:" + e);
		}
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Associado other = (Associado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	private static void	validadorDocumentos (Validator<String> validador, String documento) {
		validador.assertValid(documento);
	}
	
}
