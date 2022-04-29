package com.fiap.brq.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fiap.brq.entities.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

	@Query(value = "SELECT * FROM tb_candidato cd WHERE (UPPER(cd.nome) LIKE UPPER(CONCAT('%', ?1, '%')) OR cd.email = ?1 OR cd.cpf = ?1) ORDER BY cd.nome ASC",
			nativeQuery = true)
	List<Candidato> buscarTudo(String conteudo);


}
