package com.projeto.coperativa;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author lucas.martins
 *
 */
@Entity
@Table (name = "Pauta")
public class Pauta{

		
	 	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 	@Column(name = "id")
		private Long id;
		private String titulo;
		private String mensagem;
		private LocalDateTime dataCriacao = LocalDateTime.now();
		@Enumerated(EnumType.STRING)
		private StatusSessao status = StatusSessao.NÃO_VOTADO;
		
		
		public Pauta() {
		}
		
		public Pauta(String titulo, String mensagem, StatusSessao status) {
			this.titulo = titulo;
			this.mensagem = mensagem;
			this.status = status;
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
			Pauta other = (Pauta) obj;
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
}
