package com.fiap.brq.dto;

import java.util.List;

public class CreateCertificacaoDTO {
	
	private String nomeCertificacao;
	
	private List<String> skills;
	
	public CreateCertificacaoDTO() {
		
	}

	public CreateCertificacaoDTO(String nomeCertificacao, List<String> skills) {
		super();
		this.nomeCertificacao = nomeCertificacao;
		this.skills = skills;
	}

	public String getNomeCertificacao() {
		return nomeCertificacao;
	}

	public void setNomeCertificacao(String nomeCertificacao) {
		this.nomeCertificacao = nomeCertificacao;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	
	

}
