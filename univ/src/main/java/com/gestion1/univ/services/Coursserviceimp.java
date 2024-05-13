package com.gestion1.univ.services;


import com.gestion1.univ.entitites.Cours;
import com.gestion1.univ.repositories.Coursrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Coursserviceimp  implements Coursservice{
    @Autowired
    private Coursrepository coursrepository;

    @Override
    public Cours saveCours(Cours cours) {
        return coursrepository.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursrepository.save(cours);
    }

    @Override
    public void deleteCoursById(Long idCours) {
           coursrepository.deleteById(idCours);
    }

    @Override
    public void deleteAllCours() {
        coursrepository.deleteAll();

    }

    @Override
    public Cours getCoursById(Long idCours) {
        return coursrepository.findById(idCours).get();
    }

    @Override
    public List<Cours> getAllCours() {
        return coursrepository.findAll();
    }
}


