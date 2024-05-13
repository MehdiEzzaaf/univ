package com.gestion1.univ.services;



import com.gestion1.univ.entitites.Examen;
import com.gestion1.univ.repositories.Examenrepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Examenserviceimp implements Examenservice{
    private Examenrepository examenrepository;
    @Override
    public Examen saveExamen(Examen examen) {
        return examenrepository.save(examen);
    }

    @Override
    public Examen updateExamen(Examen examen) {
        return examenrepository.save(examen);
    }

    @Override
    public void deleteExamenById(Long idexam) {
       examenrepository.deleteById(idexam);
    }

    @Override
    public void deleteAllExamens() {
         examenrepository.deleteAll();
    }

    @Override
    public Examen getExamenById(Long idexam) {
        return examenrepository.findById(idexam).get();
    }

    @Override
    public List<Examen> getAllExamens() {
        return  examenrepository.findAll();
    }
}
