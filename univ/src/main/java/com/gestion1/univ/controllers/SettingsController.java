package com.gestion1.univ.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SettingsController {

    @GetMapping("/settings")
    public String showSettingsPage() {
        return "Settings"; // Assuming your settings page HTML is named "settings.html"
    }

}

