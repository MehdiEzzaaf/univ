package com.gestion1.univ.controllers;

import com.gestion1.univ.entitites.Filiere;
import com.gestion1.univ.services.Filiereservice;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class FiliereController {

    @Autowired
    private Filiereservice filiereService;

    @RequestMapping("/createFiliere")
    public String createFiliere(ModelMap model) {
        model.addAttribute("filiereVue", new Filiere());
        return "CreateFiliere";
    }

    @RequestMapping(value = "/saveFiliere", method = RequestMethod.POST)
    public String saveFiliere(@ModelAttribute("filiereVue") Filiere filiere) {
        filiereService.saveFiliere(filiere);
        return "redirect:/filiereList";
    }

    @RequestMapping("/filiereList")
    public String filiereList(ModelMap modelMap) {
        List<Filiere> filieres = filiereService.getAllFilieres();
        modelMap.addAttribute("filieresVue", filieres);
        return "FiliereList";
    }

    @RequestMapping("/deleteFiliere")
    public String deleteFiliere(@RequestParam("id") Long idFiliere) {
        filiereService.deleteFilierebyId(idFiliere);
        return "redirect:/filiereList";
    }

    @RequestMapping("/editFiliere")
    public String editFiliere(@RequestParam("id") Long idFiliere, ModelMap modelMap) {
        Filiere filiere = filiereService.getFilierebyId(idFiliere);
        modelMap.addAttribute("filiereVue", filiere);
        return "EditFiliere";
    }

    @RequestMapping(value = "/updateFiliere", method = RequestMethod.POST)
    public String updateFiliere(@ModelAttribute("filiereVue") Filiere filiere) {
        filiereService.updateFiliere(filiere);
        return "redirect:/filiereList";
    }
}

