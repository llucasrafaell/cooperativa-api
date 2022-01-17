package com.projeto.coperativa.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.projeto.coperativa.Pauta;
import com.projeto.coperativa.StatusSessao;
import com.projeto.coperativa.repository.PautaRepository;

public class PautaForm {
	
	@NotNull @NotEmpty @Length(min=3)
	private String titulo;
	@NotNull @NotEmpty @Length(min=5)
	private String mensagem;
		
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public Pauta converter (PautaRepository pautaRepository) {
		return new Pauta(titulo, mensagem);
	}
	

}
