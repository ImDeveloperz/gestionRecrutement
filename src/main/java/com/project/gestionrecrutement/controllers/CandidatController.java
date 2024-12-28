package com.project.gestionrecrutement.controllers;

import com.project.gestionrecrutement.entities.Candidat;
import com.project.gestionrecrutement.entities.Recruteur;
import com.project.gestionrecrutement.entities.Utilisateur;
import com.project.gestionrecrutement.repositories.CandidatRepository;
import com.project.gestionrecrutement.services.CandidatService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class CandidatController {
    @Autowired
    private CandidatService candidatService;

    @GetMapping("/candidat")
    public String showCandidatPage(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        Utilisateur user= (Utilisateur) session.getAttribute("user");
        if(user instanceof Recruteur){
            session.invalidate();
            return "redirect:/login";
        }
        model.addAttribute("user", session.getAttribute("user"));
        return "candidat";
    }



    @GetMapping("/register")
    public String showRegistrationForm(HttpSession session , Model model) {
        model.addAttribute("candidat", new Candidat());

        return "register";
    }

    @PostMapping("/register")
    public String registerCandidat(@ModelAttribute Candidat candidat, Model model) {
        try {
            candidatService.registerCandidat(candidat);
            return "redirect:/login";
        } catch (RuntimeException e) {
            model.addAttribute("error", "Email already used");
            return "register";
        }
    }
}
