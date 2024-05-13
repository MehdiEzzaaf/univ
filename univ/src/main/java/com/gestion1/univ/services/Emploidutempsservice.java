package com.gestion1.univ.services;




import com.gestion1.univ.entitites.Emploidutemps;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Emploidutempsservice {
    Emploidutemps saveEmploidutemps(Emploidutemps emploidutemps);
    Emploidutemps updateEmploidutemps(Emploidutemps emploidutemps);
    void deleteEmploidutempsById(Long idemp);
    void deleteAllEmploidutemps();
    Emploidutemps getEmploidutempsById(Long idemp);
    List<Emploidutemps> getAllEmploidutemps();
}
