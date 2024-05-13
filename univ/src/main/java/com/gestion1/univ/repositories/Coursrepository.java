package com.gestion1.univ.repositories;


import com.gestion1.univ.entitites.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Coursrepository extends JpaRepository<Cours,Long> {
}
