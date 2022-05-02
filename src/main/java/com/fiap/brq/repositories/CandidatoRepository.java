package com.fiap.brq.repositories;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fiap.brq.entities.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    boolean existsByEmailOrCpf(String email, String cpf);

    @Query("SELECT candidato FROM Candidato candidato JOIN candidato.skills skill " +
            "WHERE candidato.id IN (:candidatosIds) " +
            "AND skill.id IN (:skillsIds)" +
            "GROUP BY candidato.id ")
    Set<Candidato> findByIdInAndSkillsIds(@Param("candidatosIds") Collection<Long> ids, @Param("skillsIds") Collection<Long> skillsIds);

    @Query("SELECT candidato FROM Candidato candidato " + "WHERE (:query IS NULL OR ("
	    + "UPPER(candidato.nome) LIKE UPPER(CONCAT('%', :query, '%')) " + "OR candidato.email = :query "
	    + "OR candidato.cpf = :query)" + ")")
    Set<Candidato> findByQuery(@Param("query") String query);
}