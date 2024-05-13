package com.gestion1.univ.services;


import com.gestion1.univ.entitites.Emploidutemps;
import com.gestion1.univ.repositories.Emploidutempsrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Emploidutempsserviceimp implements Emploidutempsservice{
    @Autowired
    private Emploidutempsrepository emploidutempsrepository;
    @Override
    public Emploidutemps saveEmploidutemps(Emploidutemps emploidutemps) {
        return emploidutempsrepository.save(emploidutemps);
    }

    @Override
    public Emploidutemps updateEmploidutemps(Emploidutemps emploidutemps) {
        return emploidutempsrepository.save(emploidutemps);
    }

    @Override
    public void deleteEmploidutempsById(Long idemp) {
         emploidutempsrepository.deleteById(idemp);
    }

    @Override
    public void deleteAllEmploidutemps() {
           emploidutempsrepository.deleteAll();
    }

    @Override
    public Emploidutemps getEmploidutempsById(Long idemp) {
        return emploidutempsrepository.findById(idemp).get();
    }

    @Override
    public List<Emploidutemps> getAllEmploidutemps() {
        return emploidutempsrepository.findAll();
    }
}
