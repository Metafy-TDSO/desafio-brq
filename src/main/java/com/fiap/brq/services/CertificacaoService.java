package com.fiap.brq.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.brq.entities.Certificacao;
import com.fiap.brq.repositories.CertificacaoRepository;

@Service
public class CertificacaoService {

	@Autowired
	private CertificacaoRepository repository;
		
	public Certificacao insert(Certificacao certificacao) {
		return repository.save(certificacao);
	}
	
	
	
}
