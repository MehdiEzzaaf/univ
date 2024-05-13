package com.gestion1.univ.services;


import com.gestion1.univ.entitites.Note;
import com.gestion1.univ.repositories.Noterepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Noteserviceimp implements Noteservice{
    @Autowired
    private Noterepository noterepository;
    @Override
    public Note saveNote(Note note) {
        return noterepository.save(note);
    }

    @Override
    public Note updateNote(Note note) {
        return noterepository.save(note);
    }

    @Override
    public void deleteNoteById(Long idnote) {
          noterepository.deleteById(idnote);
    }

    @Override
    public void deleteAllNotes() {
         noterepository.deleteAll();
    }

    @Override
    public Note getNoteById(Long idnote) {
        return noterepository.findById(idnote).get();
    }

    @Override
    public List<Note> getAllNotes() {
        return noterepository.findAll();
    }
}
