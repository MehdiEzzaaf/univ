package com.gestion1.univ.services;


import com.gestion1.univ.entitites.Note;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface Noteservice {
    Note saveNote(Note note);
    Note updateNote(Note note);
    void deleteNoteById(Long idnote);
    void deleteAllNotes();
    Note getNoteById(Long idnote);
    List<Note> getAllNotes();

}
