package com.gestion1.univ.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/loginPage")
    public String showLoginForm() {
        return "loginPage";
    }

    @PostMapping("/loginPage")
    public String login() {
        // Vérifier les informations de connexion et rediriger en conséquence
        return "redirect:/homepage";
    }
}

