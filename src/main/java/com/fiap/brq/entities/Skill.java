package com.fiap.brq.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_skill")
public class Skill implements Serializable {
    private static final long serialVersionUID = 1L;

    public static long getSerialversionuid() {
	return serialVersionUID;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeSkill;

    @ManyToMany(mappedBy = "skills")
    @JsonIgnore
    private List<Certificacao> certificacao;

    @ManyToMany(mappedBy = "skills")
    @JsonIgnore
    private List<Candidato> candidatos;

    public Skill() {

    }

    public Skill(Long id, List<Candidato> candidatos, String nomeSkill) {
	super();
	this.id = id;
	this.nomeSkill = nomeSkill;
	this.candidatos = candidatos;
    }

    public Skill(Long id, String nomeSkill) {
	super();
	this.id = id;
	this.nomeSkill = nomeSkill;
    }

    public Skill(Long id, String nomeSkill, List<Certificacao> certificacao) {
	super();
	this.id = id;
	this.nomeSkill = nomeSkill;
	this.certificacao = certificacao;
    }

    public Skill(Long id, String nomeSkill, List<Certificacao> certificacao, List<Candidato> candidatos) {
	super();
	this.id = id;
	this.nomeSkill = nomeSkill;
	this.certificacao = certificacao;
	this.candidatos = candidatos;
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
		&& Objects.equals(id, other.id) && Objects.equals(nomeSkill, other.nomeSkill);
    }

    public List<Candidato> getCandidatos() {
	return candidatos;
    }

    public List<Certificacao> getCertificacao() {
	return certificacao;
    }

    public Long getId() {
	return id;
    }

    public String getNomeSkill() {
	return nomeSkill;
    }

    @Override
    public int hashCode() {
	return Objects.hash(candidatos, certificacao, id, nomeSkill);
    }

    public void setCandidatos(List<Candidato> candidatos) {
	this.candidatos = candidatos;
    }

    public void setCertificacao(List<Certificacao> certificacao) {
	this.certificacao = certificacao;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public void setNomeSkill(String nomeSkill) {
	this.nomeSkill = nomeSkill;
    }
}
