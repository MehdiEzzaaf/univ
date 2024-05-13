package com.gestion1.univ.services;



import com.gestion1.univ.entitites.Etudiant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Etudiantservice {
    Etudiant saveEtudiant (Etudiant etudiant);
    Etudiant updateEtudiant (Etudiant etudiant);
    void deleteEtudiantbyId(Long idetud);
    void deleteAllEtudiants();
    Etudiant getEtudiantbyId(Long idetud);
    List<Etudiant> getAllEtudiants();


}


