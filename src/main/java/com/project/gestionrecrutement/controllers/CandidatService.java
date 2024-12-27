package com.project.gestionrecrutement.controllers;

import com.project.gestionrecrutement.repositories.CandidatureRepository;
import com.project.gestionrecrutement.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
}
