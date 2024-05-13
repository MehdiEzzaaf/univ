package com.gestion1.univ.services;


import com.gestion1.univ.entitites.Enseignant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public interface Enseignantservice {
    Enseignant saveEnseignant(Enseignant enseignant);

    Enseignant updateEnseignant(Enseignant enseignant);

    void deleteEnseignant(Long id);

    Enseignant getEnseignantById(Long id);

    List<Enseignant> getAllEnseignants();

    void deleteEnseignantById(Long idens);
}


