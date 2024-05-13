package com.gestion1.univ.repositories;


import com.gestion1.univ.entitites.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface Enseignantrepository extends JpaRepository<Enseignant,Long> {
}
