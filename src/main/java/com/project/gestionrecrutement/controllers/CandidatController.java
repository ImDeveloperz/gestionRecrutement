package com.project.gestionrecrutement.controllers;

import com.project.gestionrecrutement.entities.Candidat;
import com.project.gestionrecrutement.repositories.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/candidats") //
public class CandidatController {
    @Autowired
    private CandidatRepository candidatRepository;
    @GetMapping
    public String listCandidats(Model model) {
        model.addAttribute("candidats", candidatRepository.findAll());
        return "candidats/list";
    }
    @GetMapping("/new")
    public String creercandidat(Model model) {
        model.addAttribute("candidat", new Candidat());
        return "candidats/create";
    }
    @PostMapping//??
    public String SaveCandidat(@ModelAttribute("candidat") Candidat candidat) {
        candidatRepository.save(candidat);
        return "redirect:/candidats";
    }
    @GetMapping("/edit/{id}")
    public String forModif(@PathVariable("id") Long id, Model model) {
        Optional<Candidat> candidat = candidatRepository.findById(id);
        if (candidat.isPresent()) {
            model.addAttribute("candidat", candidat.get());
            return "candidats/edit";
        }
        return "redirect:/candidats";
    }
    @PostMapping("/update/{id}")
    public String updateCandidat(@PathVariable("id") Long id, @ModelAttribute("candidat") Candidat candidat) {
        candidat.setId(id);
        candidatRepository.save(candidat);
        return "redirect:/candidats";
    }
    @GetMapping("/delete/{id}")
    public String deleteCandidat(@PathVariable("id") Long id) {
        candidatRepository.deleteById(id);
        return "redirect:/candidats";
    }




}
