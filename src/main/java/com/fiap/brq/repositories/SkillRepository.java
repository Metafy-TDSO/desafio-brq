package com.fiap.brq.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fiap.brq.entities.Candidato;
import com.fiap.brq.entities.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
	
	Skill findByLinguagem(String linguagem);

}
