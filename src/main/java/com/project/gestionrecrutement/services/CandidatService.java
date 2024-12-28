package com.project.gestionrecrutement.services;

import com.project.gestionrecrutement.entities.Candidat;
import com.project.gestionrecrutement.repositories.CandidatRepository;
import com.project.gestionrecrutement.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatService {
    @Autowired
    private CandidatRepository candidatRepository;

    public Candidat registerCandidat(Candidat candidat) {
        if (candidatRepository.findByEmail(candidat.getEmail()) != null) {
            throw new RuntimeException("Email already used");
        }
        return candidatRepository.save(candidat);
    }
}
