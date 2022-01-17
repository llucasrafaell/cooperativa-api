package com.projeto.coperativa.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.projeto.coperativa.Pauta;
import com.projeto.coperativa.Sessao;
import com.projeto.coperativa.StatusSessao;

public class SessaoPautaDto {
	
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	private StatusSessao status = StatusSessao.NÃO_VOTADO;
	
	public SessaoPautaDto() {
		// TODO Auto-generated constructor stub
	}
	public SessaoPautaDto(Pauta pauta, Sessao sessao) {
		this.id = pauta.getId();
		this.titulo = pauta.getTitulo();
	    this.mensagem = pauta.getMensagem();
	    this.dataCriacao = pauta.getDataCriacao();
	    this.status = sessao.getStatus();
	}
	public SessaoPautaDto (Pauta pauta) {
		this.id = pauta.getId();
		this.titulo = pauta.getTitulo();
	    this.mensagem = pauta.getMensagem();
	    this.dataCriacao = pauta.getDataCriacao();
	    //this.status = sessao.getStatus(); 
	}
	
	public SessaoPautaDto (Sessao sessao) {
	
	    this.status = sessao.getStatus(); 
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public StatusSessao getStatus() {
		return status;
	}

	public void setStatus(StatusSessao status) {
		this.status = status;
	}

	
	public static List<SessaoPautaDto> converter(List<Pauta> pauta, List<Sessao> sessao){
		
		return pauta.stream().map(SessaoPautaDto::new).collect(Collectors.toList());			
	}
		
}

//public static List<SessaoPautaDto> converter(List<Pauta> pauta, List<Sessao> sessao){
//	//return pauta.stream().map(SessaoPautaDto::new).collect(Collectors.toList());
//	
//	List<SessaoPautaDto> sessaoPautaDto = new ArrayList<>();
//	
//	for(Pauta p: pauta) {
//		
//		SessaoPautaDto dto = new SessaoPautaDto(p,s);
//		sessaoPautaDto.add(dto);
//		
//	}
//	return sessaoPautaDto;
//}
