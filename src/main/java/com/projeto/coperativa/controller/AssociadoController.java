package com.projeto.coperativa.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.projeto.coperativa.Associado;
import com.projeto.coperativa.controller.dto.AssociadoDto;
import com.projeto.coperativa.controller.form.AssociadoForm;
import com.projeto.coperativa.repository.AssociadoRepository;


@Controller
@RequestMapping("/associado")
public class AssociadoController {


	  @Autowired
	  private AssociadoRepository associadoRepository;
	  
	  @ResponseBody
      @GetMapping
	  public List<AssociadoDto> lista (String nome) {
		  if (nome == null) {
              List<Associado> associado = associadoRepository.findAll();
              return AssociadoDto.converter(associado);
       } else {
           List<Associado> associado = associadoRepository.findByNome(nome);
               return AssociadoDto.converter(associado);
       }
	  }
	  
	  @ResponseBody
      @PostMapping
	  public ResponseEntity<AssociadoDto> cadastrar(@RequestBody @Valid AssociadoForm form, UriComponentsBuilder uriBuilder) {
		  Associado associado =  form.converter(associadoRepository);
		  associadoRepository.save(associado);
		  
		  URI uri = uriBuilder.path("/associados/{id}").buildAndExpand(associado.getId()).toUri();
		  return ResponseEntity.created(uri).body(new AssociadoDto(associado));
	  }
    
}
