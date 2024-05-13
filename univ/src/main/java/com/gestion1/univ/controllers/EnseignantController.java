package com.gestion1.univ.controllers;




import com.gestion1.univ.entitites.Enseignant;
import com.gestion1.univ.services.Enseignantservice;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class EnseignantController {

    @Autowired
    private Enseignantservice enseignantService;

    @GetMapping("/createEnseignant")
    public String createEnseignant(Model model) {
        model.addAttribute("enseignantVue", new Enseignant());
        return "CreateEnseignant";
    }

    @RequestMapping(value = "/saveEnseignant", method = RequestMethod.POST)
    public String saveEnseignant(@ModelAttribute("enseignantVue") Enseignant enseignant) {
        enseignantService.saveEnseignant(enseignant);
        return "redirect:/enseignantList";
    }

    @RequestMapping("/enseignantList")
    public String enseignantList(Model model) {
        List<Enseignant> enseignants = enseignantService.getAllEnseignants();
        model.addAttribute("enseignantsVue", enseignants);
        return "EnseignantList";
    }

    @RequestMapping("/deleteEnseignant")
    public String deleteEnseignant(@RequestParam("id") Long idEnseignant) {
        System.out.println("/////////////////////////////"+idEnseignant);
        enseignantService.deleteEnseignant(idEnseignant);
        return "redirect:/enseignantList";
    }

    @RequestMapping("/editEnseignant")
    public String editEnseignant(@RequestParam("id") Long idEnseignant, Model model) {
        Enseignant enseignant = enseignantService.getEnseignantById(idEnseignant);
        model.addAttribute("enseignantVue", enseignant);
        return "EditEnseignant";
    }

    @RequestMapping("/updateEnseignant")
    public String updateEnseignant(@ModelAttribute("enseignantVue") Enseignant enseignant) {
        enseignantService.updateEnseignant(enseignant);
        return "redirect:/enseignantList";
    }
}

