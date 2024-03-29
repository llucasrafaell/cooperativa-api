package com.projeto.coperativa.controller;

import java.net.URI;
import java.util.List;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;
import com.projeto.coperativa.Associado;
import com.projeto.coperativa.controller.dto.AssociadoDto;
import com.projeto.coperativa.controller.form.AssociadoForm;
import com.projeto.coperativa.repository.AssociadoRepository;

@Controller
@RequestMapping("/associados")
public class AssociadoController {

	  @Autowired
	  private AssociadoRepository associadoRepository;
	  
	  @ResponseBody
      @GetMapping
	  public List<AssociadoDto> lista () {
           List<Associado> associado = associadoRepository.findAll();
           return AssociadoDto.converter(associado);
	  }
	  
	  @ResponseBody
      @PostMapping
	  public ResponseEntity<AssociadoDto> cadastrar(@RequestBody @Valid AssociadoForm form, UriComponentsBuilder uriBuilder) {
		  Associado associado =  form.converter(associadoRepository);
		  associadoRepository.save(associado);
		  
		  URI uri = uriBuilder.path("/associados/{id}").buildAndExpand(associado.getId()).toUri();
		  return ResponseEntity.created(uri).body(new AssociadoDto(associado));
	  }
	  
	  @ResponseBody
	  @GetMapping("/{id}") 
	  public AssociadoDto detalhar(@PathVariable Long id) {
	   	 Associado associado = associadoRepository.getById(id);
	   	 return new AssociadoDto(associado);
	  }
	  
	  @ResponseBody
	  @PutMapping("/{id}")
	  @Transactional
	  public ResponseEntity<AssociadoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AssociadoForm form){
		  Associado associado = form.atualizar(id, associadoRepository);
	   	  return ResponseEntity.ok(new AssociadoDto(associado));
	     }
	  
	   @ResponseBody
	   @DeleteMapping("/{id}")
	   @Transactional
	   public ResponseEntity<?> remover(@PathVariable Long id) {
		   associadoRepository.deleteById(id);
		   return ResponseEntity.ok().build();
	   }
    
}
