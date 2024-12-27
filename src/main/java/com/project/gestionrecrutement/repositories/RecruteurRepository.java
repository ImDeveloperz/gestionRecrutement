package com.project.gestionrecrutement.repositories;

import com.project.gestionrecrutement.entities.Recruteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruteurRepository extends JpaRepository<Recruteur, Long> {
}
