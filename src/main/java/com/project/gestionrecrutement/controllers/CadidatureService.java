package com.project.gestionrecrutement.controllers;

import com.project.gestionrecrutement.repositories.CandidatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadidatureService {

    @Autowired
    private CandidatureRepository candidatureRepository;
}
