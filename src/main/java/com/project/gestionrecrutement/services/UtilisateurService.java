package com.project.gestionrecrutement.services;

import com.project.gestionrecrutement.entities.Utilisateur;
import com.project.gestionrecrutement.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur login(String email,String password) {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        if(utilisateur != null && utilisateur.getPassword().equals(password)){
            return utilisateur;
        }
        return null;
    }

    public Utilisateur getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id).orElse(null);
    }

    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }
}