package com.project.gestionrecrutement.controllers;

import com.project.gestionrecrutement.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecruteurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
}
