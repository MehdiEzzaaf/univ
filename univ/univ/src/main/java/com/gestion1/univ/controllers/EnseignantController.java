package com.gestion1.univ.controllers;

import com.gestion1.univ.entitites.Enseignant;
import com.gestion1.univ.services.Enseignantservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EnseignantController {

    @Autowired
    private Enseignantservice enseignantService;

    @RequestMapping("/createEnseignant")
    public String createEnseignant(ModelMap model) {
        model.addAttribute("enseignantVue", new Enseignant());
        return "CreateEnseignant";
    }

    @RequestMapping(value = "/saveEnseignant", method = RequestMethod.POST)
    public String saveEnseignant(@ModelAttribute("enseignantVue") Enseignant enseignant) {
        enseignantService.saveEnseignant(enseignant);
        return "redirect:/enseignantList";
    }

    @RequestMapping("/enseignantList")
    public String enseignantList(ModelMap modelMap) {
        List<Enseignant> enseignants = enseignantService.getAllEnseignants();
        modelMap.addAttribute("enseignantsVue", enseignants);
        return "EnseignantList";
    }

    @RequestMapping("/deleteEnseignant")
    public String deleteEnseignant(@RequestParam("id") Long idens, ModelMap modelMap) {
        enseignantService.deleteEnseignantById(idens);
        List<Enseignant> enseignants = enseignantService.getAllEnseignants();
        modelMap.addAttribute("enseignantsVue", enseignants);
        return "EnseignantList";
    }

    @RequestMapping("/editEnseignant")
    public String editEnseignant(@RequestParam("id") Long id, ModelMap modelMap) {
        Enseignant enseignant = enseignantService.getEnseignantById(id);
        modelMap.addAttribute("enseignantVue", enseignant);
        return "EditEnseignant";
    }

    @RequestMapping("/updateEnseignant")
    public String updateEnseignant(@ModelAttribute("enseignantVue") Enseignant enseignant) {
        enseignantService.updateEnseignant(enseignant);
        return createEnseignant(new ModelMap());
    }
}
