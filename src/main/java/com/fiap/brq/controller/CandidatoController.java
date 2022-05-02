package com.fiap.brq.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fiap.brq.dto.CreateCandidatoDTO;
import com.fiap.brq.entities.Candidato;
import com.fiap.brq.services.CandidatoService;

@RestController
@RequestMapping(value = "/candidatos")
public class CandidatoController {
    @Autowired
    private CandidatoService candidatoService;

    @GetMapping
    public ResponseEntity<List<Candidato>> buscarTudo(@RequestParam(name = "query", required = false) String query,
	    @RequestParam(name = "skills", required = false) String querySkills) {
	List<String> skills = new ArrayList<String>();

	if (querySkills != null) {
	    skills = Arrays.asList(querySkills.split(","));
	}

	Set<Candidato> resultado = this.candidatoService.findAllByQueries(query, skills);

	return ResponseEntity.ok().body(resultado.stream().collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<Candidato> insert(@RequestBody CreateCandidatoDTO reqBody) {
	Candidato candidato = candidatoService.signUp(reqBody);

	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(candidato.getId())
		.toUri();
	return ResponseEntity.created(uri).body(candidato);
    }
}
