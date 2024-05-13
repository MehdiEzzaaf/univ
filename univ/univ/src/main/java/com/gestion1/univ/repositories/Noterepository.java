package com.gestion1.univ.repositories;


import com.gestion1.univ.entitites.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Noterepository extends JpaRepository<Note, Long> {
}
