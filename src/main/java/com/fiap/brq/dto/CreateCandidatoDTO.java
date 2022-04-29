package com.fiap.brq.dto;

import java.util.List;

public class CreateCandidatoDTO {
	
	private String nome;
	
	private String cpf;
	
	private String email;
	
	private String genero;
	
	private String dataNascimento;
	
	private List<String> skills;
	
	private List<CreateCertificacaoDTO> certs;
	
	public CreateCandidatoDTO() {
		
	}

	public CreateCandidatoDTO(String nome, String cpf, String email, String genero, String dataNascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
	}

	public CreateCandidatoDTO(String nome, String cpf, String email, String genero, String dataNascimento,
			List<String> skills) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
		this.skills = skills;
	}

	public CreateCandidatoDTO(String nome, String cpf, String email, String genero, String dataNascimento,
			List<String> skills, List<CreateCertificacaoDTO> certs) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
		this.skills = skills;
		this.certs = certs;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public List<CreateCertificacaoDTO> getCerts() {
		return certs;
	}

	public void setCerts(List<CreateCertificacaoDTO> certs) {
		this.certs = certs;
	}
	
}
