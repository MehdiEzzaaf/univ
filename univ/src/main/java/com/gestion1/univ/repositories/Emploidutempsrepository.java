package com.gestion1.univ.repositories;


import com.gestion1.univ.entitites.Emploidutemps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Emploidutempsrepository extends JpaRepository<Emploidutemps,Long> {
}
