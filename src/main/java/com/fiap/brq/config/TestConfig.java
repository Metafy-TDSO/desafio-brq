package com.fiap.brq.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

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
		Candidato c1 = new Candidato(null, "Diego", "37910013884", "diego.cruz@gmail.com", "Masculino", new GregorianCalendar(1991, Calendar.FEBRUARY, 5));
		Candidato c2 = new Candidato(null, "Tiago", "123456789", "tiago@gmail.com", "Masculino", new GregorianCalendar(1998, Calendar.MAY, 9));		
		Candidato c3 = new Candidato(null, "Enzo", "987654321", "enzo@gmail.com", "Masculino", new GregorianCalendar(2000, Calendar.APRIL, 15));		
		Candidato c4 = new Candidato(null, "Guilherme", "65498321", "guilherme@gmail.com", "Masculino", new GregorianCalendar(2001, Calendar.DECEMBER, 23));
		Candidato c5 = new Candidato(null, "Hugo", "312457975", "hugo@gmail.com", "Masculino", new GregorianCalendar(2003, Calendar.OCTOBER, 7));
		
		candidatoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));

		
		Skill sk1 = new Skill(null, "Java", 2, c1);
		Skill sk2 = new Skill(null, "SQL", 2, c1);

		Skill sk3 = new Skill(null, "Python", 3, c2);
		
		Skill sk4 = new Skill(null, "JavaScript", 3, c3);

		Skill sk5 = new Skill(null, "JavaScript", 3, c4);
		
		Skill sk6 = new Skill(null, "C#", 3, c4);
		
		skillRepository.saveAll(Arrays.asList(sk1, sk2, sk3, sk4, sk5, sk6));


		Certificacao cert1 = new Certificacao(null, "Java", sk1);
		Certificacao cert2 = new Certificacao(null, "Oracle", sk1);
		Certificacao cert3 = new Certificacao(null, "Spring", sk1);
		
		Certificacao cert4 = new Certificacao(null, "Administracao", sk2);
		Certificacao cert5 = new Certificacao(null, "RH", sk2);
		Certificacao cert6 = new Certificacao(null, "Financas", sk2);
		
		Certificacao cert7 = new Certificacao(null, "Front", sk3);
		Certificacao cert8 = new Certificacao(null, "Scrum", sk3);
		
		Certificacao cert9 = new Certificacao(null, "Front", sk4);
		Certificacao cert10 = new Certificacao(null, "JavaScript", sk4);
		Certificacao cert11 = new Certificacao(null, "MySQL", sk4);
		
		Certificacao cert12 = new Certificacao(null, "Agilidade", sk5);		
		Certificacao cert13 = new Certificacao(null, "Strategia", sk6);	


		certificacaoRepository.saveAll(Arrays.asList(cert1, cert2, cert3, cert4, cert5, cert6, cert7, cert8, cert9, cert10, cert11, cert12, cert13));

	}

}
