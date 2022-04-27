package com.fiap.brq.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fiap.brq.entities.Candidato;
import com.fiap.brq.services.CandidatoService;

@RestController
@RequestMapping(value = "/candidatos")
public class CandidatoController {
	
	@Autowired
	private CandidatoService service;
	
	@GetMapping
	public ResponseEntity<List<Candidato>> findAll(){
		List<Candidato> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}
	
	@PostMapping
	public ResponseEntity<Candidato> insert(@RequestBody Candidato candidato) {
		candidato = service.insert(candidato);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(candidato.getId()).toUri();
		return ResponseEntity.created(uri).body(candidato);
	}
	
	
	
	

}
