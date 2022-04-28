package com.fiap.brq.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_certificacao")
public class Certificacao implements Serializable{	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeCertificacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="skill_id")
	@JsonIgnore
	private Skill skill;

	public Certificacao() {
		
	}

	public Certificacao(Long id, String nomeCertificacao, Skill skill) {
		super();
		this.id = id;
		this.nomeCertificacao = nomeCertificacao;
		this.skill = skill;
	}
	
	public Certificacao(Long id, String nomeCertificacao) {
		super();
		this.id = id;
		this.nomeCertificacao = nomeCertificacao;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCertificacao() {
		return nomeCertificacao;
	}

	public void setNomeCertificacao(String nomeCertificacao) {
		this.nomeCertificacao = nomeCertificacao;
	}
	

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Certificacao other = (Certificacao) obj;
		return Objects.equals(id, other.id);
	}
	
	

	
	
}
