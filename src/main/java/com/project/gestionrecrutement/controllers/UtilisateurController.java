package com.project.gestionrecrutement.controllers;

import com.project.gestionrecrutement.entities.Candidat;
import com.project.gestionrecrutement.entities.Utilisateur;
import com.project.gestionrecrutement.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public String getAllUtilisateurs(Model model) {
        List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateurs();
        model.addAttribute("utilisateurs", utilisateurs);
        return "utilisateurs/list";
    }

    @GetMapping("/{id}")
    public String getUtilisateurById(@PathVariable Long id, Model model) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
        model.addAttribute("utilisateur", utilisateur);
        return "utilisateurs/detail";
    }

    @GetMapping("/new")
    public String createUtilisateurForm(Model model) {
        model.addAttribute("utilisateur", new Candidat());
        return "utilisateurs/form";
    }

    @PostMapping
    public String saveUtilisateur(@ModelAttribute Utilisateur utilisateur) {
        utilisateurService.saveUtilisateur(utilisateur);
        return "redirect:/utilisateurs";
    }

    @GetMapping("/delete/{id}")
    public String deleteUtilisateur(@PathVariable Long id) {
        utilisateurService.deleteUtilisateur(id);
        return "redirect:/utilisateurs";
    }
}