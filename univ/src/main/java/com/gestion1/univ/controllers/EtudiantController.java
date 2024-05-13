package com.gestion1.univ.controllers;


import com.gestion1.univ.entitites.Etudiant;
import com.gestion1.univ.entitites.Filiere;
import com.gestion1.univ.services.Etudiantservice;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class EtudiantController {

    @Autowired
    private Etudiantservice etudiantService;

    @GetMapping("/createEtudiant")
    public String createEtudiant(Model model) {
        model.addAttribute("etudiantVue", new Etudiant());
        return "CreateEtudiant";
    }

    @RequestMapping(value = "/saveEtudiant", method = RequestMethod.POST)
    public String saveEtudiant(@ModelAttribute("etudiantVue") Etudiant etudiant) {
        etudiantService.saveEtudiant(etudiant);
        return "redirect:/etudiantList";
    }

    @RequestMapping("/etudiantList")
    public String etudiantList(Model model) {
        List<Etudiant> etudiants = etudiantService.getAllEtudiants();
        model.addAttribute("etudiantsVue", etudiants);
        return "EtudiantList";
    }

    @RequestMapping("/deleteEtudiant/{id}")
    public String deleteEtudiant(@PathVariable("id") Long idEtudiant) {
        etudiantService.deleteEtudiantbyId(idEtudiant);
        return "redirect:/etudiantList";
    }

    @RequestMapping("/editEtudiant")
    public String editEtudiant(@RequestParam("id") Long idetud, Model modelMap) {
        System.out.println(":::::::::::::::::::::::::::"+ idetud);
        Etudiant etudiant=etudiantService.getEtudiantbyId(idetud);
        modelMap.addAttribute("etudiantVue", etudiant);
        return "EditEtudiant";
    }

    @RequestMapping("/updateEtudiant")
    public String updateEtudiant(@RequestParam("id") Long idEtudiant,
                                 @RequestParam("prenom") String prenom,
                                 @RequestParam("nom") String nom,
                                 @RequestParam("age") int age,
                                 @RequestParam("niveau") String niveau,
                                 @RequestParam("email") String email,
                                 @RequestParam("adresse") String adresse) {
        Etudiant etudiant = etudiantService.getEtudiantbyId(idEtudiant);
        etudiant.setPrenom(prenom);
        etudiant.setNom(nom);
        etudiant.setAge(age);
        etudiant.setNiveau(niveau);
        etudiant.setEmail(email);
        etudiant.setAdress(adresse);
        etudiantService.updateEtudiant(etudiant);
        return "redirect:/etudiantList";
    }
}
