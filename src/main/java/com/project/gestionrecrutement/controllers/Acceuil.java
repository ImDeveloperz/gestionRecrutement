package com.project.gestionrecrutement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Acceuil {
        @GetMapping("/")
        public String acceuil() {
            return "acceuil";
        }
}