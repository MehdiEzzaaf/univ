package com.gestion1.univ.services;


import com.gestion1.univ.entitites.Filiere;
import com.gestion1.univ.repositories.Filiererepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Filiereserviceimp implements Filiereservice {
    @Autowired
    private Filiererepository filiererepository;
    @Override
    public Filiere saveFiliere(Filiere filiere) {
        return filiererepository.save(filiere);
    }

    @Override
    public Filiere updateFiliere(Filiere filiere) {
        return filiererepository.save(filiere);
    }

    @Override
    public void deleteFilierebyId(Long idfil) {
         filiererepository.deleteById(idfil);
    }

    @Override
    public void deleteAllFilieres() {
        filiererepository.deleteAll();
    }

    @Override
    public Filiere getFilierebyId(Long idfil) {
        return filiererepository.findById(idfil).get();
    }

    @Override
    public List<Filiere> getAllFilieres() {
        return filiererepository.findAll();
    }
}
