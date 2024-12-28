package com.project.gestionrecrutement.controllers;
import com.project.gestionrecrutement.entities.Candidature;
import com.project.gestionrecrutement.repositories.CandidatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/candidatures")
public class CandidatureController {
    @Autowired
    private CandidatureRepository candidatureRepository;
    @GetMapping
    public String listCandidatures(Model model) {
        model.addAttribute("candidatures", candidatureRepository.findAll()); // Ajouter les candidatures au modèle
        return "candidatures/list"; // Retourner la vue "list.html" (dossier templates/candidatures)
    }
    @GetMapping("/new")
    public String creercandidature(Model model) {
        model.addAttribute("candidature", new Candidature());
        return "candidatures/create";
    }
    @PostMapping
    public String saveCandidature(@ModelAttribute("candidature") Candidature candidature) {
        candidatureRepository.save(candidature);
        return "redirect:/candidatures";
    }
    @GetMapping("/edit/{id}")
    public String formModification(@PathVariable("id") Long id, Model model) {
        Optional<Candidature> candidature = candidatureRepository.findById(id);
        if (candidature.isPresent()) {
            model.addAttribute("candidature", candidature.get());
            return "candidatures/edit";
        }
        return "redirect:/candidatures";
    }
    @PostMapping("/update/{id}")
    public String ModifierCandidature(@PathVariable("id") Long id, @ModelAttribute("candidature") Candidature candidature) {
        candidature.setId(id);
        candidatureRepository.save(candidature);
        return "redirect:/candidatures";
    }
    @GetMapping("/delete/{id}")
    public String deleteCandidature(@PathVariable("id") Long id) {
        candidatureRepository.deleteById(id);
        return "redirect:/candidatures";
    }

}
