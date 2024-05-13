package com.gestion1.univ.repositories;


import com.gestion1.univ.entitites.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Etudiantrepository extends JpaRepository<Etudiant, Long> {
}
