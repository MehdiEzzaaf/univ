package com.gestion1.univ.controllers;

import com.gestion1.univ.entitites.Examen;
import com.gestion1.univ.services.Examenservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ExamenController {

    @Autowired
    private Examenservice examenService;

    @RequestMapping("/createExamen")
    public String createExamen(ModelMap model) {
        model.addAttribute("examenVue", new Examen());
        return "CreateExamen";
    }

    @RequestMapping(value = "/saveExamen", method = RequestMethod.POST)
    public String saveExamen(@ModelAttribute("examenVue") Examen examen) {
        examenService.saveExamen(examen);
        return "redirect:/examenList";
    }

    @RequestMapping("/examenList")
    public String examenList(ModelMap modelMap) {
        List<Examen> examens = examenService.getAllExamens();
        modelMap.addAttribute("examensVue", examens);
        return "ExamenList";
    }

    @RequestMapping("/deleteExamen")
    public String deleteExamen(@RequestParam("id") Long idexam, ModelMap modelMap) {
        examenService.deleteExamenById(idexam);
        List<Examen> examens = examenService.getAllExamens();
        modelMap.addAttribute("examensVue", examens);
        return "ExamenList";
    }

    @RequestMapping("/editExamen")
    public String editExamen(@RequestParam("id") Long idexam, ModelMap modelMap) {
        Examen examen = examenService.getExamenById(idexam);
        modelMap.addAttribute("examenVue", examen);
        return "EditExamen";
    }

    @RequestMapping("/updateExamen")
    public String updateExamen(@ModelAttribute("examenVue") Examen examen) {
        examenService.updateExamen(examen);
        return createExamen(new ModelMap());
    }
}

