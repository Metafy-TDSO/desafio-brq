package com.fiap.brq.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

	private String Linguagem;

	private int anosExperiencia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "candidato_id")
	@JsonIgnore
	private Candidato candidato;

	@OneToMany(mappedBy = "skill", cascade = CascadeType.PERSIST)
	private List<Certificacao> certificados;

	public Skill() {

	}

	public Skill(Long id, String linguagem, int anosExperiencia, Candidato candidato) {
		super();
		this.id = id;
		Linguagem = linguagem;
		this.anosExperiencia = anosExperiencia;
		this.candidato = candidato;
	}

	public Skill(Long id, String linguagem, int anosExperiencia) {
		super();
		this.id = id;
		Linguagem = linguagem;
		this.anosExperiencia = anosExperiencia;
	}

	public Skill(Long id, String linguagem, int anosExperiencia, Candidato candidato, List<Certificacao> certificados) {
		super();
		this.id = id;
		Linguagem = linguagem;
		this.anosExperiencia = anosExperiencia;
		this.candidato = candidato;
		this.certificados = certificados;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLinguagem() {
		return Linguagem;
	}

	public void setLinguagem(String linguagem) {
		Linguagem = linguagem;
	}

	public int getAnosExperiencia() {
		return anosExperiencia;
	}

	public void setAnosExperiencia(int anosExperiencia) {
		this.anosExperiencia = anosExperiencia;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}	

	public List<Certificacao> getCertificados() {
		return certificados;
	}

	public void setCertificados(List<Certificacao> certificados) {
		this.certificados = certificados;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Linguagem, anosExperiencia, candidato, id);
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
		return Objects.equals(Linguagem, other.Linguagem) && anosExperiencia == other.anosExperiencia
				&& Objects.equals(candidato, other.candidato) && Objects.equals(id, other.id);
	}

}
