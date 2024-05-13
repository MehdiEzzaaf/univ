package com.gestion1.univ.services;


import com.gestion1.univ.entitites.Filiere;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface Filiereservice {
    Filiere saveFiliere (Filiere filiere);
    Filiere updateFiliere (Filiere filiere);
    void deleteFilierebyId(Long idfil);
    void deleteAllFilieres();
    Filiere getFilierebyId(Long idfil);
    List<Filiere> getAllFilieres();

}
