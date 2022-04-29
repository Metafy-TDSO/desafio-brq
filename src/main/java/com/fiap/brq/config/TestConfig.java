package com.fiap.brq.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fiap.brq.entities.Candidato;
import com.fiap.brq.entities.Certificacao;
import com.fiap.brq.entities.Skill;
import com.fiap.brq.repositories.CandidatoRepository;
import com.fiap.brq.repositories.CertificacaoRepository;
import com.fiap.brq.repositories.SkillRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@Autowired	
	private CertificacaoRepository certificacaoRepository;
	
	@Autowired	
	private SkillRepository skillRepository;
	

	@Override
	public void run(String... args) throws Exception {	
		
		Skill sk1 = new Skill(null, "Java");
		Skill sk2 = new Skill(null, "SQL");
		Skill sk3 = new Skill(null, "Python");
		Skill sk4 = new Skill(null, "JavaScript");
		Skill sk5 = new Skill(null, "TypeScript");
		Skill sk6 = new Skill(null, "C#");
		
		Set<Skill> c1_skill = new HashSet<Skill>();
		c1_skill.add(sk1);
		c1_skill.add(sk2);
		
		Set<Skill> c2_skill = new HashSet<Skill>();
		c2_skill.add(sk3);
		
		Set<Skill> c3_skill = new HashSet<Skill>();
		c3_skill.add(sk4);
		
		Set<Skill> c4_skill = new HashSet<Skill>();
		c4_skill.add(sk5);
		c4_skill.add(sk6);
		
		Certificacao cert1 = new Certificacao(null, "Java Hibernate", c1_skill);
		Certificacao cert2 = new Certificacao(null, "Python Web", c2_skill);
		Certificacao cert3 = new Certificacao(null, "Vanilla Javascript", c3_skill);
		Certificacao cert4 = new Certificacao(null, "Typescript", c4_skill);
		Certificacao cert5 = new Certificacao(null, "C# .NET", c4_skill);
		
		Set<Certificacao> c1_cert = new HashSet<Certificacao>();
		c1_cert.add(cert1);
		
		Set<Certificacao> c2_cert = new HashSet<Certificacao>();
		c2_cert.add(cert2);
		
		Set<Certificacao> c3_cert = new HashSet<Certificacao>();
		c3_cert.add(cert3);
		
		Set<Certificacao> c4_cert = new HashSet<Certificacao>();
		c4_cert.add(cert4);
		c4_cert.add(cert5);
		
		Candidato c1 = new Candidato(null, "Diego", "37910013884", "diego.cruz@gmail.com", "Masculino", new GregorianCalendar(1991, Calendar.FEBRUARY, 5), c1_skill, c1_cert);
		Candidato c2 = new Candidato(null, "Tiago", "123456789", "tiago@gmail.com", "Masculino", new GregorianCalendar(1998, Calendar.MAY, 9), c2_skill, c2_cert);		
		Candidato c3 = new Candidato(null, "Enzo", "987654321", "enzo@gmail.com", "Masculino", new GregorianCalendar(2000, Calendar.APRIL, 15), c3_skill, c3_cert);		
		Candidato c4 = new Candidato(null, "Guilherme", "65498321", "guilherme@gmail.com", "Masculino", new GregorianCalendar(2001, Calendar.DECEMBER, 23), c4_skill, c4_cert);
		Candidato c5 = new Candidato(null, "Hugo", "312457975", "hugo@gmail.com", "Masculino", new GregorianCalendar(2003, Calendar.OCTOBER, 7), c2_skill);
		
		candidatoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
	}

}
