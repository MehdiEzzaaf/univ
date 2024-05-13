package com.gestion1.univ.services;


import com.gestion1.univ.entitites.Etablissement;
import com.gestion1.univ.repositories.Etablissementrepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class Etablissementserviceimp implements Etablissementservice {
    private Etablissementrepository etablissementrepository;
    @Override
    public Etablissement saveEtablissement(Etablissement etablissement) {
        return  etablissementrepository.save(etablissement);
    }

    @Override
    public Etablissement updateEtablissement(Etablissement etablissement) {
        return  etablissementrepository.save(etablissement);
    }

    @Override
    public void deleteEtablissementbyId(Long idEtab) {
        etablissementrepository.deleteById(idEtab);
    }

    @Override
    public void deleteAllEtablissements() {
        etablissementrepository.deleteAll();
    }

    @Override
    public Etablissement getEtablissementbyId(Long idEtab) {
        return etablissementrepository.findById(idEtab).get();
    }

    @Override
    public List<Etablissement> getAllEtablissements() {
        return etablissementrepository.findAll();
    }
}
