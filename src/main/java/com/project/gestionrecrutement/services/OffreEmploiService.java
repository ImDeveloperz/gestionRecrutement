package com.project.gestionrecrutement.services;

import com.project.gestionrecrutement.entities.OffreEmploi;
import com.project.gestionrecrutement.repositories.OffreEmploiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OffreEmploiService {

    @Autowired
    private OffreEmploiRepository offreEmploiRepository;

    public List<OffreEmploi> getAllOffreEmploi() {
        return offreEmploiRepository.findAll();
    }

    public Optional<OffreEmploi> getOffreEmploiById(Long id){
        return offreEmploiRepository.findById(id);
    }

    public void createOffreEmploi(OffreEmploi offreEmploi){
        offreEmploiRepository.save(offreEmploi);
    }

    public void updateOffreEmploi(OffreEmploi offreEmploi){
        offreEmploiRepository.save(offreEmploi);
    }

    public void deleteOffreEmploiById(Long id){
        offreEmploiRepository.deleteById(id);
    }

}
