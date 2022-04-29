package com.fiap.brq.controller;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fiap.brq.dto.CreateCandidatoDTO;
import com.fiap.brq.dto.CreateCertificacaoDTO;
import com.fiap.brq.entities.Candidato;
import com.fiap.brq.entities.Certificacao;
import com.fiap.brq.entities.Skill;
import com.fiap.brq.services.CandidatoService;
import com.fiap.brq.services.CertificacaoService;
import com.fiap.brq.services.SkillService;

@RestController
@RequestMapping(value = "/candidatos")
public class CandidatoController {
	
	@Autowired
	private CandidatoService service;
	
	@Autowired
	private SkillService skillService;
	
	@Autowired
	private CertificacaoService certService;
	
	@PostMapping
	public ResponseEntity<Candidato> insert(@RequestBody CreateCandidatoDTO reqBody) throws ParseException {
	
		List<String> skills = reqBody.getSkills();
		Set<Skill> dbSkills = new HashSet<Skill>(); 
		
		for (String skill : skills) {
			dbSkills.add(skillService.findOrCreateByName(skill));
		}
		
		List<CreateCertificacaoDTO> certs = reqBody.getCerts();
		Set<Certificacao> dbCerts = new HashSet<Certificacao>();
		for (CreateCertificacaoDTO cert: certs) {			
			List<String> certSkills = cert.getSkills();
			Set<Skill> dbCertSkills = new HashSet<Skill>();
			
			for (String skill : certSkills) {
				dbCertSkills.add(skillService.findOrCreateByName(skill));
			}
			
			dbCerts.add(certService.findOrCreateByName(cert.getNomeCertificacao(), dbCertSkills));
			
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf.parse(reqBody.getDataNascimento());
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		Candidato candidato = service.insert(new Candidato(null, reqBody.getNome(), reqBody.getCpf(), reqBody.getEmail(), reqBody.getGenero(), cal, dbSkills, dbCerts));
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(candidato.getId()).toUri();
		return ResponseEntity.created(uri).body(candidato);
	}
	
	@GetMapping
	public ResponseEntity<List<Candidato>> buscarTudo(@RequestParam String conteudo){
		List<Candidato> resultado = service.buscarTudo(conteudo);
		return ResponseEntity.ok().body(resultado);

	}

	
	
	
	

}
