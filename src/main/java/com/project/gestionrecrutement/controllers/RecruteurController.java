package com.project.gestionrecrutement.controllers;

import com.project.gestionrecrutement.entities.Candidat;
import com.project.gestionrecrutement.entities.Recruteur;
import com.project.gestionrecrutement.entities.Utilisateur;
import com.project.gestionrecrutement.services.RecruteurService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/recruteur")
public class RecruteurController {

    @Autowired
    private RecruteurService recruteurService;

    @GetMapping
    public String getRecruteur(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        Utilisateur user= (Utilisateur) session.getAttribute("user");
        if(user instanceof Candidat){
            session.invalidate();
            return "redirect:/login";
        }
        model.addAttribute("user", session.getAttribute("user"));
        return "recruteur";
    }

}