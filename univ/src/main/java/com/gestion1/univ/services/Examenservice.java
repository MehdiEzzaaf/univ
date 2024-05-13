package com.gestion1.univ.services;



import com.gestion1.univ.entitites.Examen;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Examenservice {
    Examen saveExamen(Examen examen);
    Examen updateExamen(Examen examen);
    void deleteExamenById(Long idexam);
    void deleteAllExamens();
    Examen getExamenById(Long idexam);
    List<Examen> getAllExamens();
}
