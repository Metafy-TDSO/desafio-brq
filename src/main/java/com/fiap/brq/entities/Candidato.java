package com.fiap.brq.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_candidato")
public class Candidato implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;

    private String genero;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private Calendar dataNascimento;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "tb_candidato_skill", joinColumns = { @JoinColumn(name = "candidato_id") }, inverseJoinColumns = {
	    @JoinColumn(name = "skill_id") })
    private Set<Skill> skills;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "tb_candidato_certificacao", joinColumns = {
	    @JoinColumn(name = "candidato_id") }, inverseJoinColumns = { @JoinColumn(name = "certificacao_id") })
    private Set<Certificacao> certs;

    public Candidato() {

    }

    public Candidato(Long id, String nome, String cpf, String email, String genero, Calendar dataNascimento) {
	super();
	this.id = id;
	this.nome = nome;
	this.cpf = cpf;
	this.email = email;
	this.genero = genero;
	this.dataNascimento = dataNascimento;

    }

    public Candidato(Long id, String nome, String cpf, String email, String genero, Calendar dataNascimento,
	    Set<Skill> skills) {
	super();
	this.id = id;
	this.nome = nome;
	this.cpf = cpf;
	this.email = email;
	this.genero = genero;
	this.dataNascimento = dataNascimento;
	this.skills = skills;
    }

    public Candidato(Long id, String nome, String cpf, String email, String genero, Calendar dataNascimento,
	    Set<Skill> skills, Set<Certificacao> certs) {
	super();
	this.id = id;
	this.nome = nome;
	this.cpf = cpf;
	this.email = email;
	this.genero = genero;
	this.dataNascimento = dataNascimento;
	this.skills = skills;
	this.certs = certs;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Candidato other = (Candidato) obj;
	return Objects.equals(id, other.id);
    }

    public Set<Certificacao> getCerts() {
	return certs;
    }

    public String getCpf() {
	return cpf;
    }

    public Calendar getDataNascimento() {
	return dataNascimento;
    }

    public String getEmail() {
	return email;
    }

    public String getGenero() {
	return genero;
    }

    public Long getId() {
	return id;
    }

    public String getNome() {
	return nome;
    }

    public Set<Skill> getSkills() {
	return skills;
    }

    @Override
    public int hashCode() {
	return Objects.hash(id);
    }

    public void setCerts(Set<Certificacao> certs) {
	this.certs = certs;
    }

    public void setCpf(String cpf) {
	this.cpf = cpf;
    }

    public void setDataNascimento(Calendar dataNascimento) {
	this.dataNascimento = dataNascimento;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public void setGenero(String genero) {
	this.genero = genero;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public void setSkills(Set<Skill> skills) {
	this.skills = skills;
    }
}
