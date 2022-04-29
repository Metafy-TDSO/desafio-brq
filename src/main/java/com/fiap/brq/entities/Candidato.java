package com.fiap.brq.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
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
import javax.persistence.OneToMany;
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
	@JoinTable(name="tb_candidato_skill", 
			   joinColumns={@JoinColumn(name="candidato_id")}, 
			   inverseJoinColumns={@JoinColumn(name="skill_id")})
	private Set<Skill> skills;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="tb_candidato_certificacao", 
			   joinColumns={@JoinColumn(name="candidato_id")}, 
			   inverseJoinColumns={@JoinColumn(name="certificacao_id")})
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	public Set<Certificacao> getCerts() {
		return certs;
	}

	public void setCerts(Set<Certificacao> certs) {
		this.certs = certs;
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
		Candidato other = (Candidato) obj;
		return Objects.equals(id, other.id);
	}

}
