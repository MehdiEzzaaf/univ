package com.gestion1.univ.repositories;


import com.gestion1.univ.entitites.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Examenrepository extends JpaRepository<Examen, Long> {
}
