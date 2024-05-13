package com.gestion1.univ.services;

import com.gestion1.univ.entitites.Etablissement;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface Etablissementservice {
    Etablissement saveEtablissement (Etablissement etablissement);
    Etablissement updateEtablissement ( Etablissement etablissement);
    void deleteEtablissementbyId(Long idEtab);
    void deleteAllEtablissements();
    Etablissement getEtablissementbyId(Long idEtab);
    List<Etablissement> getAllEtablissements();

}
