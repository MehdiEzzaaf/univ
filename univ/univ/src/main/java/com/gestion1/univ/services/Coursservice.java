package com.gestion1.univ.services;



import com.gestion1.univ.entitites.Cours;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Coursservice {
    Cours saveCours(Cours cours);
    Cours updateCours(Cours cours);
    void deleteCoursById(Long idCours);
    void deleteAllCours();
    Cours getCoursById(Long idCours);
    List<Cours> getAllCours();

}
