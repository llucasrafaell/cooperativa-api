package com.projeto.coperativa.controller.form;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.projeto.coperativa.Sessao;
import com.projeto.coperativa.StatusSessao;
import com.projeto.coperativa.repository.SessaoRepository;

public class SessaoForm {
	
	@Enumerated(EnumType.STRING)
	private StatusSessao status;
	@NotNull @NotEmpty @Length(min=3)
	private String titulo;
	@NotNull @NotEmpty @Length(min=5)
	private String mensagem;

	public StatusSessao getStatus() {
		return status;
	}

	public void setStatus(StatusSessao status) {
		this.status = status;
	}
	
	
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

	public Sessao converter(SessaoRepository sessaoRepository) {
		return new Sessao(status);
	}

}
