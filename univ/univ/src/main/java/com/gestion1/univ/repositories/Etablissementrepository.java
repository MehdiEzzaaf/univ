package com.gestion1.univ.repositories;


import com.gestion1.univ.entitites.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Etablissementrepository extends JpaRepository<Etablissement, Long> {
}
