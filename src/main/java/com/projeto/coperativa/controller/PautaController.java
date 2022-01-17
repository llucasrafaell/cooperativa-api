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

import com.projeto.coperativa.Pauta;
import com.projeto.coperativa.controller.dto.PautaDto;
import com.projeto.coperativa.controller.form.PautaForm;
import com.projeto.coperativa.repository.PautaRepository;

@Controller
@RequestMapping("/pauta")
public class PautaController {
	
	@Autowired
	private PautaRepository pautaRepository;
	
	 @ResponseBody
     @GetMapping
     public List<PautaDto> lista(){
		 List<Pauta> pautas = pautaRepository.findAll();
		 return PautaDto.converter(pautas);
	 }
	 
	 @ResponseBody
	 @PostMapping
	 public ResponseEntity<PautaDto> cadastrar (@RequestBody @Valid PautaForm form, UriComponentsBuilder uriBuilder){
		 Pauta pauta = form.converter(pautaRepository);
		 pautaRepository.save(pauta);
		 
		 URI uri = uriBuilder.path("/pauta/{id}").buildAndExpand(pauta.getId()).toUri();
		 return ResponseEntity.created(uri).body(new PautaDto(pauta));
	 }
	 
}
