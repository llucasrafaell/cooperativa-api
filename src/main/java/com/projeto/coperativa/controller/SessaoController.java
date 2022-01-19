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
import com.projeto.coperativa.Pauta;
import com.projeto.coperativa.Sessao;
import com.projeto.coperativa.controller.dto.SessaoPautaDto;
import com.projeto.coperativa.controller.form.SessaoPautaForm;
import com.projeto.coperativa.repository.PautaRepository;
import com.projeto.coperativa.repository.SessaoRepository;
 
@Controller
@RequestMapping("/sessoes")

public class SessaoController {
	
	@Autowired
	private PautaRepository pautaRepository;
	
	@Autowired
	private SessaoRepository sessaoRepository;
	
	 @ResponseBody
     @GetMapping
     public List<SessaoPautaDto> lista(){
		 List<Pauta> pautas = pautaRepository.findAll();
		 List<Sessao> sessao = sessaoRepository.findAll(); 
		 return SessaoPautaDto.converter(pautas, sessao);
	 }
	 
	 @ResponseBody
	 @PostMapping
	 public ResponseEntity<SessaoPautaDto> cadastrar (@RequestBody @Valid SessaoPautaForm form, 
			UriComponentsBuilder uriBuilder){
		 
		 Pauta pauta = form.converter(pautaRepository);
		 pautaRepository.save(pauta);
		 Sessao sessao = form.converter(sessaoRepository);
		 sessaoRepository.save(sessao); 
		 URI uri = uriBuilder.path("/sessao/{id}").buildAndExpand(sessao.getId()).toUri();
		 return ResponseEntity.created(uri).body(new SessaoPautaDto(pauta));
	 }
	 
	 @ResponseBody
	 @GetMapping("/{id}") 
	 public SessaoPautaDto detalhar(@PathVariable Long id) {
	   	Pauta pauta = pautaRepository.getById(id);
	   	return new SessaoPautaDto(pauta);
	 }
	 
	 @ResponseBody
     @PutMapping("/{id}")
     @Transactional
     public ResponseEntity<SessaoPautaDto> atualizar(@PathVariable Long id, @RequestBody @Valid SessaoPautaForm form){
		 Pauta pauta = form.atualizar(id, pautaRepository);
   	  	  return ResponseEntity.ok(new SessaoPautaDto(pauta));
     }
	 
	 @ResponseBody
	 @DeleteMapping("/{id}")
	 @Transactional
	 public ResponseEntity<?> remover(@PathVariable Long id) {
		 pautaRepository.deleteById(id);
		 sessaoRepository.deleteById(id);
		 return ResponseEntity.ok().build();
	   }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
//	 @ResponseBody
//	 @PostMapping
//	 public ResponseEntity<SessaoPautaDto> cadastrar (@RequestBody @Valid SessaoForm sessaoForm, @RequestBody @Valid PautaForm pautaForm, UriComponentsBuilder uriBuilder){
//		 //Pauta pauta = pautaForm.converter(pautaRepository);
//		 //pautaRepository.save(pauta);
//		 
//		 Sessao sessao = sessaoForm.converter(sessaoRepository);
//		 sessaoRepository.save(sessao);
//		 
//		 URI uri= uriBuilder.path("/sessao/{id}").buildAndExpand(sessao.getId()).toUri();
//		 
//		 return ResponseEntity.created(uri).body(new SessaoPautaDto(sessao));
//	 }
	 
//	 @ResponseBody
//	 @PostMapping
//	 public void cadastrar (@RequestBody @Valid PautaForm formPauta, @RequestBody @Valid SessaoForm formSessao){
//		 Pauta pauta = formPauta.converter(pautaRepository);
//		 pautaRepository.save(pauta);
//		 Sessao sessao = formSessao.converter(sessaoRepository);
//		 sessaoRepository.save(sessao);
//	 }
	
}
