package com.project.gestionrecrutement.repositories;

import com.project.gestionrecrutement.entities.OffreEmploi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffreEmploiRepository extends JpaRepository<OffreEmploi, Long> {
}