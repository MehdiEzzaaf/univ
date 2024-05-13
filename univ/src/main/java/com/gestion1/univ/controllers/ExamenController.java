package com.gestion1.univ.controllers;


import com.gestion1.univ.entitites.Examen;
import com.gestion1.univ.services.Coursserviceimp;
import com.gestion1.univ.services.Examenservice;
import com.gestion1.univ.services.Examenserviceimp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class ExamenController {

    @Autowired
    private Examenserviceimp examenserviceimp;
    @Autowired
    private Coursserviceimp coursserviceimp;

    @GetMapping("/createExamen")
    public String createExamen(Model model) {
        model.addAttribute("examenVue", new Examen());
        return "CreateExamen";
    }

    @PostMapping("/saveExamen")
    public String saveExamen(@ModelAttribute("examenVue") Examen examen) {
        examenserviceimp.saveExamen(examen);
        return "ExamenList";
    }

    @GetMapping("/ExamenList")
    public String examenList(Model model) {
        List<Examen> examenList = examenserviceimp.getAllExamens();
        model.addAttribute("examenList", examenList);
        examenList.forEach(System.out::println);
        return "ExamenList";
    }

    @GetMapping("/deleteExamen/{id}")
    public String deleteExamen(@PathVariable("id") Long idExamen) {
        examenserviceimp.deleteExamenById(idExamen);
        return "redirect:/examenList";
    }

    @GetMapping("/editExamen")
    public String editExamen(@RequestParam("id") Long idExamen, Model model) {
        Examen examen = examenserviceimp.getExamenById(idExamen);
        model.addAttribute("examenVue", examen);
        return "EditExamen";
    }

    @PostMapping("/updateExamen")
    public String updateExamen(@ModelAttribute("examenVue") Examen examen) {
        examenserviceimp.updateExamen(examen);
        return "redirect:/examenList";
    }
}
