package com.fiap.brq.config;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fiap.brq.entities.Candidato;
import com.fiap.brq.entities.Certificacao;
import com.fiap.brq.entities.Skill;
import com.fiap.brq.repositories.CandidatoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private CandidatoRepository candidatoRepository;

    @Override
    public void run(String... args) throws Exception {
	Skill java = new Skill(null, "Java");
	Skill sql = new Skill(null, "SQL");
	Skill python = new Skill(null, "Python");
	Skill js = new Skill(null, "JavaScript");
	Skill ts = new Skill(null, "TypeScript");
	Skill csharp = new Skill(null, "C#");
	Skill scrum = new Skill(null, "Scrum");

	List<Skill> scrumSkills = new ArrayList<>();
	scrumSkills.add(scrum);

	List<Skill> tsWeb = new ArrayList<>();
	tsWeb.add(js);
	tsWeb.add(ts);
	tsWeb.add(sql);
	tsWeb.add(scrum);

	List<Skill> jsSimple = new ArrayList<>();
	jsSimple.add(js);

	List<Skill> javaBackend = new ArrayList<>();
	javaBackend.add(scrum);
	javaBackend.add(sql);
	javaBackend.add(java);

	List<Skill> pythonWeb = new ArrayList<>();
	pythonWeb.add(js);
	pythonWeb.add(python);

	List<Skill> csharpWeb = new ArrayList<>();
	csharpWeb.add(js);
	csharpWeb.add(csharp);

	Certificacao javaCert = new Certificacao(null, "Java Hibernate", javaBackend);
	Certificacao pythonCert = new Certificacao(null, "Django Web - Python", pythonWeb);
	Certificacao jsCert = new Certificacao(null, "Vanilla Javascript", jsSimple);
	Certificacao tsCert = new Certificacao(null, "Typescript Advanced", tsWeb);
	Certificacao csharpCert = new Certificacao(null, ".NET Udemy", csharpWeb);
	Certificacao scrumCert = new Certificacao(null, "Srum Master", scrumSkills);

	List<Certificacao> certsDiego = new ArrayList<>();
	certsDiego.add(javaCert);
	certsDiego.add(scrumCert);

	List<Certificacao> certsTiago = new ArrayList<>();
	certsTiago.add(pythonCert);

	List<Certificacao> certsEnzo = new ArrayList<>();
	certsEnzo.add(csharpCert);
	certsEnzo.add(jsCert);

	List<Certificacao> certsGuilherme = new ArrayList<>();
	certsGuilherme.add(javaCert);
	certsGuilherme.add(tsCert);
	certsGuilherme.add(jsCert);
	certsGuilherme.add(scrumCert);

	Candidato c1 = new Candidato(null, "Diego", "37910013884", "diego.cruz@gmail.com", "Masculino",
		new GregorianCalendar(1991, Calendar.FEBRUARY, 5), javaBackend, certsDiego);
	Candidato c2 = new Candidato(null, "Tiago", "123456789", "tiago@gmail.com", "Masculino",
		new GregorianCalendar(1998, Calendar.MAY, 9), pythonWeb, certsTiago);
	Candidato c3 = new Candidato(null, "Enzo", "987654321", "enzo@gmail.com", "Masculino",
		new GregorianCalendar(2000, Calendar.APRIL, 15), csharpWeb, certsEnzo);
	Candidato c4 = new Candidato(null, "Guilherme", "65498321", "guilherme@gmail.com", "Masculino",
		new GregorianCalendar(2001, Calendar.DECEMBER, 23), tsWeb, certsGuilherme);
	Candidato c5 = new Candidato(null, "Hugo", "312457975", "hugo@gmail.com", "Masculino",
		new GregorianCalendar(2003, Calendar.OCTOBER, 7), jsSimple);

	candidatoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
    }

}
