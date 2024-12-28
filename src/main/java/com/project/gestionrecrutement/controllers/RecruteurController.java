package com.project.gestionrecrutement.controllers;

import com.project.gestionrecrutement.entities.Recruteur;
import com.project.gestionrecrutement.services.RecruteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/recruteurs")
public class RecruteurController {

    @Autowired
    private RecruteurService recruteurService;

    @GetMapping
    public String getAllRecruteurs(Model model) {
        List<Recruteur> recruteurs = recruteurService.getAllRecruteurs();
        model.addAttribute("recruteurs", recruteurs);
        return "recruteurs/list";
    }

    @GetMapping("/{id}")
    public String getRecruteurById(@PathVariable Long id, Model model) {
        Recruteur recruteur = recruteurService.getRecruteurById(id);
        model.addAttribute("recruteur", recruteur);
        return "recruteurs/detail";
    }

    @GetMapping("/new")
    public String createRecruteurForm(Model model) {
        model.addAttribute("recruteur", new Recruteur());
        return "recruteurs/form";
    }

    @PostMapping
    public String saveRecruteur(@ModelAttribute Recruteur recruteur) {
        recruteurService.saveRecruteur(recruteur);
        return "redirect:/recruteurs";
    }

    @GetMapping("/delete/{id}")
    public String deleteRecruteur(@PathVariable Long id) {
        recruteurService.deleteRecruteur(id);
        return "redirect:/recruteurs";
    }
}