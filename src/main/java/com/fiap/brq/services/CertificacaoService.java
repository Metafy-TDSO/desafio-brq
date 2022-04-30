package com.fiap.brq.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.brq.dto.CreateCertificacaoDTO;
import com.fiap.brq.entities.Certificacao;
import com.fiap.brq.entities.Skill;
import com.fiap.brq.repositories.CertificacaoRepository;

@Service
public class CertificacaoService {
    @Autowired
    private CertificacaoRepository repository;

    @Autowired
    private SkillService skillService;

    public List<Certificacao> findManyBySkillsIds(List<Long> ids) {
	return repository.findBySkills_IdIn(ids);
    }

    public Certificacao findOrCreateByName(String name, List<Skill> skills) {
	Certificacao cert = repository.findByNomeCertificacao(name);
	if (cert == null)
	    cert = repository.save(new Certificacao(null, name, skills));
	return cert;
    }

    public List<Certificacao> findOrCreateMany(List<CreateCertificacaoDTO> input) {
	List<Certificacao> dbCerts = new ArrayList<>();

	for (CreateCertificacaoDTO cert : input) {
	    List<Skill> dbCertSkills = skillService.findOrCreateManyByName(cert.getSkills());

	    dbCerts.add(this.findOrCreateByName(cert.getNomeCertificacao(), dbCertSkills));
	}

	return dbCerts;
    }
}
