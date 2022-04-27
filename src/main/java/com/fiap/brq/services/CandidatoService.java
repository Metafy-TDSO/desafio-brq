package com.fiap.brq.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.brq.entities.Candidato;
import com.fiap.brq.repositories.CandidatoRepository;

@Service
public class CandidatoService {

	@Autowired
	private CandidatoRepository repository;
	
	public List<Candidato> findAll(){
		return repository.findAll();
	}
		
	public Candidato insert(Candidato candidato) {
		return repository.save(candidato);
	}
	
	public List<Candidato> findByParams(String parametros){
		return repository.findAll();
	}
	
}
