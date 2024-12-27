package com.project.gestionrecrutement.repositories;

import com.project.gestionrecrutement.entities.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatureRepository extends JpaRepository<Candidature, Long> {
}