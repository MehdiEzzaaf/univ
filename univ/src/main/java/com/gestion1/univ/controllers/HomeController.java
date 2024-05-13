package com.gestion1.univ.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {



    @GetMapping("/programs")
    public String excitingPrograms() {
        return "programs"; // Assuming excitingPrograms.html is your new exciting programs template
    }
    @GetMapping("/expansion")
    public String expansion() {
        return "expansion"; // Assuming excitingPrograms.html is your new exciting programs template
    }
    @GetMapping("/events")
    public String events() {
        return "events"; // Assuming excitingPrograms.html is your new exciting programs template
    }
    @GetMapping("/profil")
    public String profile() {
        return "profil"; // Assuming excitingPrograms.html is your new exciting programs template
    }
    @GetMapping("/profilT")
    public String profileT() {
        return "profilT"; // Assuming excitingPrograms.html is your new exciting programs template
    }
}
