package com.project.gestionrecrutement.controllers;

import com.project.gestionrecrutement.entities.Candidat;
import com.project.gestionrecrutement.entities.Recruteur;
import com.project.gestionrecrutement.entities.Utilisateur;
import com.project.gestionrecrutement.services.UtilisateurService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UtilisateurService utilisateurService;
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model, HttpSession session) {
        Utilisateur user = utilisateurService.login(email, password);
        if (utilisateurService.login(email, password) != null) {
            if(utilisateurService.login(email, password) instanceof Candidat){
                session.setAttribute("user", user);
                return "redirect:/candidat";
            }
            if(utilisateurService.login(email, password) instanceof Recruteur){
                session.setAttribute("user", user);
                return "redirect:/recruteur";
            }
            return "redirect:/";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
