package com.fiap.brq.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fiap.brq.entities.Certificacao;
import com.fiap.brq.services.CertificacaoService;

@RestController
@RequestMapping(value = "/certificacoes")
public class CertificacaoController {
	
	@Autowired
	private CertificacaoService service;	
	
	@PostMapping
	public ResponseEntity<Certificacao> insert(@RequestBody Certificacao certificacao) {
		certificacao = service.insert(certificacao);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(certificacao.getId()).toUri();
		return ResponseEntity.created(uri).body(certificacao);
	}

}
