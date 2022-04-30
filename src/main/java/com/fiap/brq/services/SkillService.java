package com.fiap.brq.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.brq.entities.Skill;
import com.fiap.brq.repositories.SkillRepository;

@Service
public class SkillService {
    @Autowired
    private SkillRepository repository;

    public List<Skill> findManyByNames(List<String> skills) {
	List<String> lowercasedSkills = new ArrayList<>();

	for (String skill : skills) {
	    lowercasedSkills.add(skill.toLowerCase());
	}

	return repository.findByNomeSkillInIgnoreCase(lowercasedSkills);
    };

    public Skill findOrCreateByName(String name) {
	Skill skill = repository.findByNomeSkill(name);
	if (skill == null)
	    skill = repository.save(new Skill(null, name));
	return skill;
    }

    public List<Skill> findOrCreateManyByName(List<String> input) {
	List<Skill> dbSkills = new ArrayList<>();

	for (String skill : input) {
	    dbSkills.add(this.findOrCreateByName(skill));
	}

	return dbSkills;
    }

    public Skill insert(Skill skill) {
	return repository.save(skill);
    }
}
