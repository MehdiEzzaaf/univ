package com.gestion1.univ.services;


import com.gestion1.univ.entitites.Enseignant;
import com.gestion1.univ.repositories.Enseignantrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;






@Service
public class Enseignantserviceimp implements Enseignantservice {

    @Autowired
    private Enseignantrepository enseignantRepository;

    @Override
    public Enseignant saveEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    @Override
    public Enseignant updateEnseignant(Enseignant enseignant) {
        // Vérifie si l'enseignant existe dans la base de données
        if (enseignantRepository.existsById(enseignant.getIdens())) {
            return enseignantRepository.save(enseignant);
        } else {
            throw new IllegalArgumentException("Enseignant non trouvé");
        }
    }

    @Override
    public void deleteEnseignant(Long id) {
        enseignantRepository.deleteById(id);
    }

    @Override
    public Enseignant getEnseignantById(Long id) {
        return enseignantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Enseignant non trouvé"));
    }

    @Override
    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }

    @Override
    public void deleteEnseignantById(Long idens) {

    }
}




