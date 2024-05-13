package com.gestion1.univ.controllers;

import com.gestion1.univ.entitites.Etablissement;
import com.gestion1.univ.entitites.Filiere;
import com.gestion1.univ.services.Etablissementservice;
import com.gestion1.univ.services.Etablissementserviceimp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@Controller
public class EtablissementController {

    @Autowired
    private Etablissementserviceimp etablissementService;
    @GetMapping("/")
    public String homepage(){
        return "homepage";
    }
    @GetMapping("/homepage")
    public String homep(){
        return "homepage";
    }

    @GetMapping("/createEtablissement")
    public String createEtablissement(Model model) {
        model.addAttribute("etablissementVue", new Etablissement());
        System.out.println("testtest");
        return "CreateEtablissement";
    }

    @PostMapping("/saveEtablissement")
    public String saveEtablissement(@ModelAttribute("etablissementVue") Etablissement etablissement, Model model) {
        System.out.println("hello world");
        etablissementService.saveEtablissement(etablissement);
        return "redirect:/etablissementList";
    }

    @RequestMapping("/etablissementList")
    public String etablissementList(ModelMap modelMap) {
        List<Etablissement> etablissements = etablissementService.getAllEtablissements();
        modelMap.addAttribute("etablissementsVue", etablissements);
        return "EtablissementList";
    }

    @RequestMapping("/deleteEtablissement/{id}")
    public String deleteEtablissement(@PathVariable("id") Long idEtablissement) {
        etablissementService.deleteEtablissementbyId(idEtablissement);
        return "redirect:/etablissementList";
    }

    @RequestMapping("/editEtablissement/{id}")
    public String editEtablissement(@PathVariable("id") Long idEtablissement, Model model) {
        Etablissement etablissement = etablissementService.getEtablissementbyId(idEtablissement);
        model.addAttribute("etablissementVue", etablissement);
        return "EditEtablissement";
    }

    @RequestMapping(value = "/updateEtablissement", method = RequestMethod.POST)
    public String updateEtablissement(@ModelAttribute("etablissementVue") Etablissement etablissement) {
        etablissementService.updateEtablissement(etablissement);
        return "redirect:/etablissementList";
    }
//    @RequestMapping("/updateEtablissement")
//    public String updateEtablissement(@RequestParam("nom") String nom,
//                                      @RequestParam("adresse") String adresse,
//                                      @RequestParam("typeEtablissement") String typeEtablissement,
//                                      @RequestParam("id")Long id ) {
//        Etablissement etablissement1=etablissementService.getEtablissementbyId(id);
//        etablissement1.setTypeEtablissement(typeEtablissement);
//        etablissement1.setAdresse(adresse);
//        etablissement1.setNom(nom);
//        etablissementService.updateEtablissement(etablissement1);
//        return "redirect:/etablissementList";
//    }

}
