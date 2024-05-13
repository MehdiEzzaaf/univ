package com.gestion1.univ.controllers;

import com.gestion1.univ.entitites.Emploidutemps;
import com.gestion1.univ.services.Emploidutempsservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class EmploidutempsController {

    @Autowired
    private Emploidutempsservice emploiDuTempsService;

    @RequestMapping("/createEmploiDuTemps")
    public String createEmploiDuTemps(ModelMap model) {
        model.addAttribute("emploiDuTempsVue", new Emploidutemps());
        return "CreateEmploiDuTemps";
    }

    @RequestMapping(value = "/saveEmploiDuTemps", method = RequestMethod.POST)
    public String saveEmploiDuTemps(@ModelAttribute("emploiDuTempsVue") Emploidutemps emploiDuTemps) {
        emploiDuTempsService.saveEmploidutemps(emploiDuTemps);
        return "redirect:/emploiDuTempsList";
    }

    @RequestMapping("/emploiDuTempsList")
    public String emploiDuTempsList(ModelMap modelMap) {
        List<Emploidutemps> emploisDuTemps = emploiDuTempsService.getAllEmploidutemps();
        modelMap.addAttribute("emploisDuTempsVue", emploisDuTemps);
        return "EmploiDuTempsList";
    }

    @RequestMapping("/deleteEmploiDuTemps")
    public String deleteEmploiDuTemps(@RequestParam("id") Long idemp) {
        emploiDuTempsService.deleteEmploidutempsById(idemp);
        return "redirect:/emploiDuTempsList";
    }

    @RequestMapping("/editEmploiDuTemps")
    public String editEmploiDuTemps(@RequestParam("id") Long idemp, ModelMap modelMap) {
        Emploidutemps emploiDuTemps = emploiDuTempsService.getEmploidutempsById(idemp);
        modelMap.addAttribute("emploiDuTempsVue", emploiDuTemps);
        return "EditEmploiDuTemps";
    }

    @RequestMapping(value = "/updateEmploiDuTemps", method = RequestMethod.POST)
    public String updateEmploiDuTemps(@ModelAttribute("emploiDuTempsVue") Emploidutemps emploiDuTemps) {
        emploiDuTempsService.updateEmploidutemps(emploiDuTemps);
        return "redirect:/emploiDuTempsList";
    }
}
