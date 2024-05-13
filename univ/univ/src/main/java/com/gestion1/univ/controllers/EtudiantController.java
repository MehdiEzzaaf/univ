package com.gestion1.univ.controllers;

import com.gestion1.univ.entitites.Etudiant;
import com.gestion1.univ.services.Etudiantservice;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class EtudiantController {
    @Autowired
    private Etudiantservice etudiantService;

    @RequestMapping("/CreateEtudiant")
    public String createEtudiant(Model model){
        model.addAttribute("etud",new Etudiant());
        return "CreateEtudiant";
    }

    @RequestMapping("/saveEtudiant")
    public String saveEtudiant(@ModelAttribute("etud") Etudiant etudiant){
        etudiantService.saveEtudiant(etudiant);
        return "redirect:/CreateEtudiant";
    }

    @RequestMapping("/EtudiantList")
    public String etudiantList(Model model){
        List<Etudiant> etudiants = etudiantService.getAllEtudiants();
        model.addAttribute("etudiantVue", etudiants);
        return "EtudiantList";
    }

    @RequestMapping("/deleteEtudiant")
    public String deleteEtudiant(@RequestParam("id") long idetud, ModelMap modelMap) {
        etudiantService.deleteEtudiantbyId(idetud);
        List<Etudiant> etudiantscontroller = etudiantService.getAllEtudiants();
        modelMap.addAttribute("etudiantVue", etudiantscontroller);
        return "redirect:/etudiantList"; // Utilisez le nom de la page correct dans la redirection
    }

    @RequestMapping("/EditEtudiant")
    public String editEtudiant(@RequestParam("id") long id ,Model model){
        Etudiant etudiant = etudiantService.getEtudiantbyId(id);
        model.addAttribute("etudiantVue" , etudiant);
        return "EditEtudiant";
    }

    @RequestMapping("/updateEtudiant")
    public String updateEtudiant(@ModelAttribute("etudiantVue") Etudiant etudiant){
        etudiantService.updateEtudiant(etudiant);
        return "redirect:/EtudiantList";
    }
}
