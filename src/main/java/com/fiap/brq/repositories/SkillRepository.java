package com.fiap.brq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.brq.entities.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    Skill findByLinguagem(String linguagem);
}
