package com.projeto.coperativa.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.projeto.coperativa.Sessao;

public class SessaoDto {

	private Long id;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	public SessaoDto (Sessao sessao) {
		this.id = sessao.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	public static List<SessaoDto> converter(List<Sessao> sessao){
		return sessao.stream().map(SessaoDto::new).collect(Collectors.toList());
	}
	
}
