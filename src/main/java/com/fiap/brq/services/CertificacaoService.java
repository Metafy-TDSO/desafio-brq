package com.fiap.brq.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.brq.entities.Certificacao;
import com.fiap.brq.entities.Skill;
import com.fiap.brq.repositories.CertificacaoRepository;

@Service
public class CertificacaoService {

	@Autowired
	private CertificacaoRepository repository;
	
	public Certificacao findOrCreateByName(String name, Set<Skill> skills) {		
		Certificacao cert = repository.findByNomeCertificacao(name);
		if (cert == null) cert = repository.save(new Certificacao(null, name, skills));
		return cert;
	};
		
	public Certificacao insert(Certificacao certificacao) {
		return repository.save(certificacao);
	}
	
	
	
}
