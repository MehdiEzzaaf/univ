package com.gestion1.univ.controllers;


import com.gestion1.univ.entitites.Cours;
import com.gestion1.univ.services.Coursservice;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor
public class CoursController {

    @Autowired
    private Coursservice coursService;

    @GetMapping("/createCours")
    public String createCours() {
        return "CreateCours";
    }

    @PostMapping("/saveCours")
    public String saveCours(@RequestParam("nom")String nom,
                            @RequestParam("heures")int heures
                            ) {
        Cours cours = new Cours(nom,heures);
        coursService.saveCours(cours);
        return "redirect:/CoursList";
    }

    @GetMapping("/CoursList")
    public String coursList(Model model) {
        List<Cours> coursList = coursService.getAllCours();
        model.addAttribute("coursVue", coursList);
        return "CoursList";
    }

    @GetMapping("/deleteCours")
    public String deleteCours(@RequestParam("id") Long idCours) {
        coursService.deleteCoursById(idCours);
        return "redirect:/CoursList";
    }

    @GetMapping("/editCours")
    public String editCours(@RequestParam("id") Long idCours, Model model) {
        Cours cours = coursService.getCoursById(idCours);
        model.addAttribute("coursVue", cours);
        return "EditCours";
    }

    @PostMapping("/updateCours")
    public String updateCours(@RequestParam("id")Long id,
                              @RequestParam("nom")String nom,
                              @RequestParam("heures")int heures) {
        Cours cours=coursService.getCoursById(id);
        cours.setNom(nom);
        cours.setHeures(heures);
        coursService.updateCours(cours);
        return "redirect:/CoursList";
    }
}

