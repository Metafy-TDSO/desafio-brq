package com.fiap.brq.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fiap.brq.entities.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    boolean existsByEmailOrCpf(String email, String cpf);

    List<Candidato> findByIdInAndSkills_IdIn(Collection<Long> ids, Collection<Long> ids1);

    @Query("SELECT candidato FROM Candidato candidato " + "WHERE (:query IS NULL OR ("
	    + "UPPER(candidato.nome) LIKE UPPER(CONCAT('%', :query, '%')) " + "OR candidato.email = :query "
	    + "OR candidato.cpf = :query)" + ")")
    List<Candidato> findByQuery(@Param("query") String query);
}