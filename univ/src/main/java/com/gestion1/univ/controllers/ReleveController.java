package com.gestion1.univ.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class ReleveController
{
    @GetMapping("/releve")
    public String releve(){
        return "releve";
    }}
