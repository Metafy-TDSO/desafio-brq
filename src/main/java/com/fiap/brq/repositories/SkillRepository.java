package com.fiap.brq.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.brq.entities.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    Skill findByNomeSkill(String nomeSkill);

    List<Skill> findByNomeSkillInIgnoreCase(List<String> nomeSkills);
}
