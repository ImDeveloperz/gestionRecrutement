package com.project.gestionrecrutement.services;

import com.project.gestionrecrutement.repositories.CandidatRepository;
import com.project.gestionrecrutement.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatService {

    @Autowired
    private CandidatRepository CandidatRepository;
}
