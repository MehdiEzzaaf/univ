package com.gestion1.univ.controllers;


import com.gestion1.univ.entitites.Emploidutemps;
import com.gestion1.univ.services.Coursservice;
import com.gestion1.univ.services.Emploidutempsservice;
import com.gestion1.univ.services.Enseignantservice;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class EmploidutempsController {

    @Autowired
    private Emploidutempsservice emploidutempsService;
    @Autowired
    private Coursservice coursservice;
    @Autowired
    private Enseignantservice enseignantservice;

    @GetMapping("/CreateEmploidutemps")
    public String createEmploidutemps(Model model) {
        model.addAttribute("emploiDuTempsVue", new Emploidutemps());
        return "CreateEmploidutemps";
    }

    @PostMapping("/saveEmploidutemps")
    public String saveEmploidutemps(@RequestParam("nom")String nom,
                                    @RequestParam("heure")int heure,
                                    @RequestParam("ense")Long ense,@RequestParam("idcours")Long idcours) {
        Emploidutemps emploidutemps = new Emploidutemps();
        emploidutemps.setHeure(heure);
        emploidutemps.setNomcours(nom);
        emploidutemps.setCours( coursservice.getCoursById(idcours));
        emploidutemps.setEnseignant(enseignantservice.getEnseignantById(ense));


        emploidutempsService.saveEmploidutemps(emploidutemps);
        return "redirect:/EmploidutempsList";
    }

    @RequestMapping("/EmploidutempsList")
    public String emploiDuTempsList(Model model) {
        List<Emploidutemps> emploiDuTempsList = emploidutempsService.getAllEmploidutemps();
        model.addAttribute("emploidutempsVue", emploiDuTempsList);
        return "EmploidutempsList";
    }

    @GetMapping("/deleteEmploidutemps/{id}")
    public String deleteEmploidutemps(@PathVariable("id") Long idEmploidutemps) {
        emploidutempsService.deleteEmploidutempsById(idEmploidutemps);
        return "redirect:/EmploidutempsList";
    }

    @GetMapping("/editEmploidutemps")
    public String editEmploidutemps(@RequestParam("id") Long idEmploidutemps, Model model) {
        Emploidutemps emploiDuTemps = emploidutempsService.getEmploidutempsById(idEmploidutemps);
        model.addAttribute("emploiDuTempsVue", emploiDuTemps);
        return "EditEmploidutemps";
    }

    @PostMapping("/updateEmploidutemps")
    public String updateEmploidutemps(@ModelAttribute("emploiDuTempsVue") Emploidutemps emploiDuTemps) {
        emploidutempsService.updateEmploidutemps(emploiDuTemps);
        return "redirect:/EmploidutempsList";
    }
}



