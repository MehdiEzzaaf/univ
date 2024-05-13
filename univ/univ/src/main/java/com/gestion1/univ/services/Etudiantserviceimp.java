package com.gestion1.univ.services;

import com.gestion1.univ.entitites.Etudiant;
import com.gestion1.univ.repositories.Etudiantrepository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class Etudiantserviceimp implements Etudiantservice{
    @Autowired
    Etudiantrepository etudiantrepository;



    @Override
    public Etudiant saveEtudiant(Etudiant etudiant) {
        return etudiantrepository.save(etudiant);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        return etudiantrepository.save(etudiant);
    }

    @Override
    public void deleteEtudiantbyId(Long idetud) {
        etudiantrepository.deleteById(idetud);
    }

    @Override
    public void deleteAllEtudiants() {
        etudiantrepository.deleteAll();
    }

    @Override
    public Etudiant getEtudiantbyId(Long idetud) {

        return  etudiantrepository.findById(idetud).get();
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantrepository.findAll();
    }
}
