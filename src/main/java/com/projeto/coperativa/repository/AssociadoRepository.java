package com.projeto.coperativa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.coperativa.Associado;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {
	
	List<Associado> findByNome(String nome);
	
}
