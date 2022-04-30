package com.fiap.brq.services;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fiap.brq.dto.CreateCandidatoDTO;
import com.fiap.brq.entities.Candidato;
import com.fiap.brq.entities.Certificacao;
import com.fiap.brq.entities.Skill;
import com.fiap.brq.exceptions.BadRequestException;
import com.fiap.brq.repositories.CandidatoRepository;

@Service
public class CandidatoService {
    @Autowired
    private CandidatoRepository repository;

    @Autowired
    private SkillService skillService;

    @Autowired
    private CertificacaoService certService;

    public List<Candidato> findAll() {
	return repository.findAll();
    }

    public List<Candidato> findAllByQueries(String query, List<String> skills) {
		List<Long> skillsIds = new ArrayList<Long>();
		List<Long> certsIds = new ArrayList<Long>();

		if ((query == null || query.isEmpty()) && skills.isEmpty()) {
			List<Candidato> foundCandidatos = repository.findAll(Sort.by(Sort.Direction.ASC, "nome"));

			this.sortCandidatos(foundCandidatos, certsIds);

			return foundCandidatos;
		}

		if (!skills.isEmpty()) {
			Collection<Skill> foundSkills = skillService.findManyByNames(skills);
			for (Skill skill : foundSkills) {
				if (skill.getId() != null) {
					skillsIds.add(skill.getId());
				}
			}

			Collection<Certificacao> foundCerts = certService.findManyBySkillsIds(skillsIds);
			for (Certificacao cert : foundCerts) {
				if (cert.getId() != null) {
					System.out.println("Cert Id: " + cert.getId());
					certsIds.add(cert.getId());
				}
			}
		}

		List<Candidato> foundCandidatos = repository.findByQuery(query);

		if (!skillsIds.isEmpty()) {
			List<Long> candidatosIds = new ArrayList<Long>();
			for (Candidato candidato : foundCandidatos) {
				candidatosIds.add(candidato.getId());
			}

			foundCandidatos = repository.findByIdInAndSkills_IdIn(candidatosIds, skillsIds);
		}

		this.sortCandidatos(foundCandidatos, certsIds);

		return foundCandidatos;
    }

    @Transactional
    public Candidato signUp(CreateCandidatoDTO input) throws BadRequestException {
	Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(false);

	try {
	    Date date = sdf.parse(input.getDataNascimento());

	    if (date.after(new Date())) {
			throw new Exception();
	    }

	    cal.setTime(date);
	} catch (Exception e) {
	    throw new BadRequestException("Data de nascimento inválida");
	}

	boolean candidatoExiste = this.verifyIfCandidatoExists(input.getEmail(), input.getCpf());

	if (candidatoExiste) {
	    throw new BadRequestException("Usuário já existe");
	}

	List<Skill> createdSkills = this.skillService.findOrCreateManyByName(input.getSkills());
	List<Certificacao> createdCerts = new ArrayList<>();

	if (input.getCerts() != null) {
	    createdCerts = this.certService.findOrCreateMany(input.getCerts());
	}

	Candidato candidato = new Candidato(null, input.getNome(), input.getCpf(), input.getEmail(), input.getGenero(),
		cal, createdSkills, createdCerts);

	return repository.save(candidato);
    }

    public boolean verifyIfCandidatoExists(String email, String cpf) {
	boolean candidatoExiste = this.repository.existsByEmailOrCpf(email, cpf);

	return candidatoExiste;
    }

	private void sortCandidatos (List<Candidato> candidatos, List<Long> certificationsIds) {
		Collections.sort(candidatos, new Comparator<Candidato>() {
			@Override
			public int compare(Candidato a, Candidato b) {
				List<Certificacao> certsA = a.getCerts();
				List<Certificacao> certsB = b.getCerts();
				Integer ocurrencesA = 0;
				Integer ocurrencesB = 0;

				for (Certificacao cert : certsA) {
					if (certificationsIds.contains(cert.getId())) {
						ocurrencesA++;
					}
				}

				for (Certificacao cert : certsB) {
					if (certificationsIds.contains(cert.getId())) {
						ocurrencesB++;
					}
				}

				return ocurrencesB.compareTo(ocurrencesA);
			}
		});
	}
}
