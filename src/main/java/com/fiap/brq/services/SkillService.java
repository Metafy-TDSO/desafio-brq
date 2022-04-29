package com.fiap.brq.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.brq.entities.Skill;
import com.fiap.brq.repositories.SkillRepository;

@Service
public class SkillService {
    @Autowired
    private SkillRepository repository;

    public Skill findOrCreateByName(String name) {
	Skill skill = repository.findByLinguagem(name);
	if (skill == null)
	    skill = repository.save(new Skill(null, name));
	return skill;
    };

    public Skill insert(Skill skill) {
	return repository.save(skill);
    }
}
