package com.gestion1.univ.controllers;

import com.gestion1.univ.entitites.Etablissement;
import com.gestion1.univ.services.Etablissementservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EtablissementController {

    @Autowired
    private Etablissementservice etablissementService;

    @RequestMapping("/createEtablissement")
    public String createEtablissement(ModelMap model) {
        model.addAttribute("etablissementVue", new Etablissement());
        return "CreateEtablissement";
    }

    @RequestMapping(value = "/saveEtablissement", method = RequestMethod.POST)
    public String saveEtablissement(@ModelAttribute("etablissementVue") Etablissement etablissement) {
        etablissementService.saveEtablissement(etablissement);
        return "redirect:/etablissementList";
    }

    @RequestMapping("/etablissementList")
    public String etablissementList(ModelMap modelMap) {
        List<Etablissement> etablissements = etablissementService.getAllEtablissements();
        modelMap.addAttribute("etablissementsVue", etablissements);
        return "EtablissementList";
    }

    @RequestMapping("/deleteEtablissement")
    public String deleteEtablissement(@RequestParam("id") Long idEtab) {
        etablissementService.deleteEtablissementbyId(idEtab);
        return "redirect:/etablissementList";
    }

    @RequestMapping("/editEtablissement")
    public String editEtablissement(@RequestParam("id") Long idEtab, ModelMap modelMap) {
        Etablissement etablissement = etablissementService.getEtablissementbyId(idEtab);
        modelMap.addAttribute("etablissementVue", etablissement);
        return "EditEtablissement";
    }

    @RequestMapping(value = "/updateEtablissement", method = RequestMethod.POST)
    public String updateEtablissement(@ModelAttribute("etablissementVue") Etablissement etablissement) {
        etablissementService.updateEtablissement(etablissement);
        return "redirect:/etablissementList";
    }
}
