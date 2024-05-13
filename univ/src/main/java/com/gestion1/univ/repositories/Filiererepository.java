package com.gestion1.univ.repositories;


import com.gestion1.univ.entitites.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Filiererepository extends JpaRepository<Filiere,Long> {
}
