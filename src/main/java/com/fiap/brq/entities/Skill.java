package com.fiap.brq.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_skill")
public class Skill implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String linguagem;
	
	@ManyToMany(mappedBy = "skills")
	@JsonIgnore
	private Set<Certificacao> certificacao;
	
	@ManyToMany(mappedBy="skills")
	@JsonIgnore
	private Set<Candidato> candidatos;

	public Skill() {

	}
	
	public Skill(Long id, String linguagem) {
		super();
		this.id = id;
		this.linguagem = linguagem;
	}

	public Skill(Long id, String linguagem, Set<Certificacao> certificacao) {
		super();
		this.id = id;
		this.linguagem = linguagem;
		this.certificacao = certificacao;
	}
	
	public Skill(Long id, Set<Candidato> candidatos, String linguagem) {
		super();
		this.id = id;
		this.linguagem = linguagem;
		this.candidatos = candidatos;
	}

	public Skill(Long id, String linguagem, Set<Certificacao> certificacao, Set<Candidato> candidatos) {
		super();
		this.id = id;
		this.linguagem = linguagem;
		this.certificacao = certificacao;
		this.candidatos = candidatos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getlinguagem() {
		return linguagem;
	}

	public void setlinguagem(String linguagem) {
		this.linguagem = linguagem;
	}

	public Set<Certificacao> getCertificacao() {
		return certificacao;
	}

	public void setCertificacao(Set<Certificacao> certificacao) {
		this.certificacao = certificacao;
	}

	public Set<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(Set<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(candidatos, certificacao, id, linguagem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skill other = (Skill) obj;
		return Objects.equals(candidatos, other.candidatos) && Objects.equals(certificacao, other.certificacao)
				&& Objects.equals(id, other.id) && Objects.equals(linguagem, other.linguagem);
	}

}
