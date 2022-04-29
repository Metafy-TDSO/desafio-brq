package com.fiap.brq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.brq.entities.Certificacao;

public interface CertificacaoRepository extends JpaRepository<Certificacao, Long> {
	
	Certificacao findByNomeCertificacao(String nome);

}
