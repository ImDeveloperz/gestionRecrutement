package com.project.gestionrecrutement.services;

import com.project.gestionrecrutement.repositories.RecruteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecruteurService {

    @Autowired
    private RecruteurRepository recruteurRepository;
}
