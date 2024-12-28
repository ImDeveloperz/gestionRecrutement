package com.project.gestionrecrutement.controllers;

import com.project.gestionrecrutement.entities.OffreEmploi;
import com.project.gestionrecrutement.services.OffreEmploiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/offreEmploi")
public class OffreEmploiController {

    @Autowired
    private OffreEmploiService offreEmploiService;

    @GetMapping
    public String getAllOffreEmploi(Model model) {
        List<OffreEmploi> offreEmploi = offreEmploiService.getAllOffreEmploi();
        model.addAttribute("listOffreEmploi", offreEmploi);
        return "offreEmploi";
    }

    @DeleteMapping("/{id}")
    public String deleteOffreEmploi(@PathVariable Long id) {
        offreEmploiService.deleteOffreEmploiById(id);
        return "redirect:/offreEmploi";
    }

    @PutMapping("/{id}")
    public String updateOffreEmploi(@PathVariable Long id, @ModelAttribute OffreEmploi updatedOffre) {
        offreEmploiService.updateOffreEmploi(updatedOffre);
        return "redirect:/offreEmploi";
    }
}
