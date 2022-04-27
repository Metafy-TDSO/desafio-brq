package com.fiap.brq.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fiap.brq.entities.Skill;
import com.fiap.brq.services.SkillService;

@RestController
@RequestMapping(value = "/skills")
public class SkillController {

	@Autowired
	private SkillService service;

	@PostMapping
	public ResponseEntity<Skill> insert(@RequestBody Skill skill) {
		skill = service.insert(skill);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(skill.getId()).toUri();
		return ResponseEntity.created(uri).body(skill);
	}
}
