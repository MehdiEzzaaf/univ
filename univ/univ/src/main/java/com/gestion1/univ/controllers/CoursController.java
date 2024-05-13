package com.gestion1.univ.controllers;
import com.gestion1.univ.entitites.Cours;
import com.gestion1.univ.services.Coursservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CoursController {

    @Autowired
    private Coursservice coursService;

    @RequestMapping("/createCours")
    public String createCours(ModelMap model) {
        model.addAttribute("coursVue", new Cours());
        return "CreateCours";
    }

    @RequestMapping(value = "/saveCours", method = RequestMethod.POST)
    public String saveCours(@ModelAttribute("coursVue") Cours cours) {
        coursService.saveCours(cours);
        return "redirect:/coursList";
    }

    @RequestMapping("/coursList")
    public String coursList(ModelMap modelMap) {
        List<Cours> cours = coursService.getAllCours();
        modelMap.addAttribute("coursVue", cours);
        return "CoursList";
    }

    @RequestMapping("/deleteCours")
    public String deleteCours(@RequestParam("id") Long idCours) {
        coursService.deleteCoursById(idCours);
        return "redirect:/coursList";
    }

    @RequestMapping("/editCours")
    public String editCours(@RequestParam("id") Long idCours, ModelMap modelMap) {
        Cours cours = coursService.getCoursById(idCours);
        modelMap.addAttribute("coursVue", cours);
        return "EditCours";
    }

    @RequestMapping(value = "/updateCours", method = RequestMethod.POST)
    public String updateCours(@ModelAttribute("coursVue") Cours cours) {
        coursService.updateCours(cours);
        return "redirect:/coursList";
    }
}
