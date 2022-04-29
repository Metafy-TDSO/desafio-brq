package com.fiap.brq.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_certificacao")
public class Certificacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCertificacao;

    @ManyToMany(mappedBy = "certs")
    @JsonIgnore
    private Set<Candidato> candidato;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "tb_skill_certificacao", joinColumns = {
	    @JoinColumn(name = "certificacao_id") }, inverseJoinColumns = { @JoinColumn(name = "skill_id") })
    private Set<Skill> skills;

    public Certificacao() {

    }

    public Certificacao(Long id, String nomeCertificacao) {
	super();
	this.id = id;
	this.nomeCertificacao = nomeCertificacao;
    }

    public Certificacao(Long id, String nomeCertificacao, Set<Skill> skills) {
	super();
	this.id = id;
	this.nomeCertificacao = nomeCertificacao;
	this.skills = skills;
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

    public Long getId() {
	return id;
    }

    public String getNomeCertificacao() {
	return nomeCertificacao;
    }

    public Set<Skill> getSkills() {
	return skills;
    }

    @Override
    public int hashCode() {
	return Objects.hash(id);
    }

    public void setId(Long id) {
	this.id = id;
    }

    public void setNomeCertificacao(String nomeCertificacao) {
	this.nomeCertificacao = nomeCertificacao;
    }

    public void setSkills(Set<Skill> skills) {
	this.skills = skills;
    }
}
