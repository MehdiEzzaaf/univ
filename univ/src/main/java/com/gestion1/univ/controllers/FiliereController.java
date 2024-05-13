package com.gestion1.univ.controllers;

import com.gestion1.univ.entitites.Etablissement;
import com.gestion1.univ.entitites.Filiere;
import com.gestion1.univ.services.Etablissementserviceimp;
import com.gestion1.univ.services.Filiereservice;
import com.gestion1.univ.services.Filiereserviceimp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class FiliereController {

    @Autowired
    private Filiereserviceimp filiereService;
    @Autowired
    private Etablissementserviceimp etablissementserviceimp;


    @GetMapping("/createFiliere")
    public String createFiliere(ModelMap model) {
        model.addAttribute("filiereVue", new Filiere());
        return "CreateFiliere";
    }

    @RequestMapping(value = "/saveFiliere", method = RequestMethod.POST)
    public String saveFiliere(@ModelAttribute("filiereVue") Filiere filiere) {
        Etablissement etab=etablissementserviceimp.getEtablissementbyId(2L);
        filiere.setEtablissement(etab);
        etab.getFilieres().add(filiere);
        filiereService.saveFiliere(filiere);
        return "redirect:/filiereList";
    }

    @RequestMapping("/filiereList")
    public String filiereList(Model modelMap) {
        List<Filiere> filieres = filiereService.getAllFilieres();
        modelMap.addAttribute("filieresVue", filieres);
        return "FiliereList";
    }

    @RequestMapping("/deleteFiliere/{id}")
    public String deleteFiliere(@PathVariable("id") Long idFiliere) {
        filiereService.deleteFilierebyId(idFiliere);
        return "redirect:/filiereList";
    }

    @RequestMapping("/editFiliere")
    public String editFiliere(@RequestParam("id") Long idFiliere, Model modelMap) {
        System.out.println(":::::::::::::::::::::::::::"+ idFiliere);
        Filiere filiere = filiereService.getFilierebyId(idFiliere);
        modelMap.addAttribute("filiereVue", filiere);
        return "EditFiliere";
    }

    @RequestMapping("/updateFilliere")
    public String updateFiliere(@RequestParam("id") Long idFiliere,
                                @RequestParam("nom")String nom,
                                @RequestParam("nombreEtudiants")int nombreEtudiants,
                                @RequestParam("nombreEnseignants")int nombreEnseignants) {
      Filiere filliere= filiereService.getFilierebyId(idFiliere);
      filliere.setNomfiliere(nom);
      filliere.setNombreEnseignants(nombreEnseignants);
      filliere.setNombreEtudiants(nombreEtudiants);
      filiereService.updateFiliere(filliere);
        return "redirect:/filiereList";
    }
}

