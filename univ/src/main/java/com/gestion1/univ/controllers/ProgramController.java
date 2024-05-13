package com.gestion1.univ.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProgramController {

    @GetMapping("/program")
    public String showProgram(Model model) {
        model.addAttribute("pageTitle", "New Exciting Programs");
        model.addAttribute("pageDescription", "Discover our latest academic offerings designed to prepare students for the future.");
        model.addAttribute("program1Title", "Program 1");
        model.addAttribute("program1Description", "Description of Program 1...");
        return "program";
    }
}
