package com.projeto.coperativa.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import com.projeto.coperativa.Pauta;

public class PautaDto {

		private Long id;
		private String titulo;
		private String mensagem;
		private LocalDateTime dataCriacao = LocalDateTime.now();
		
		public PautaDto (Pauta pauta) {
			this.titulo = pauta.getTitulo();
			this.id = pauta.getId();
		    this.mensagem = pauta.getMensagem();
		    this.dataCriacao = pauta.getDataCriacao();
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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
		
		public static List<PautaDto> converter(List<Pauta> pauta){
			return pauta.stream().map(PautaDto::new).collect(Collectors.toList());
		}
		
}
