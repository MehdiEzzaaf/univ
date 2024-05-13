package com.gestion1.univ.controllers;

import com.gestion1.univ.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignInController {

    @GetMapping("/signIn")
    public String showSignInForm() {
        // Return the view name for the sign-in form
        return "signIn";
    }

    @PostMapping("/signIn")
    public String signIn() {
        // Vérifier les informations de connexion et rediriger en conséquence
        return "redirect:/homepage";
    }
    }

