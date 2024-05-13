package com.gestion1.univ.controllers;


import com.gestion1.univ.entitites.Note;
import com.gestion1.univ.services.Etudiantserviceimp;
import com.gestion1.univ.services.Noteservice;
import com.gestion1.univ.services.Noteserviceimp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class NoteController {

    @Autowired
    private Noteserviceimp noteserviceimp;
    @Autowired
    private Etudiantserviceimp etudiantserviceimp;

    @GetMapping("/createNote")
    public String createNote(Model model) {
        model.addAttribute("noteVue", new Note());
        return "CreateNote";
    }

    @PostMapping("/saveNote" )
    public String saveNote(@ModelAttribute("noteVue") Note note, Model model) {
        noteserviceimp.saveNote(note);
        return noteList( model);
    }

    @GetMapping("/NoteList")
    public String noteList(Model model) {
        List<Note> noteList = noteserviceimp.getAllNotes();
        model.addAttribute("noteList", noteList);
        return "NoteList";
    }

    @GetMapping("/deleteNote/{id}")
    public String deleteNote(@PathVariable("id") Long idNote) {
        noteserviceimp.deleteNoteById(idNote);
        return "redirect:/noteList";
    }

    @GetMapping("/editNote")
    public String editNote(@RequestParam("id") Long idNote, Model model) {
        Note note = noteserviceimp.getNoteById(idNote);
        model.addAttribute("noteVue", note);
        return "EditNote";
    }

    @PostMapping("/updateNote")
    public String updateNote(@ModelAttribute("noteVue") Note note) {
        noteserviceimp.updateNote(note);
        return "redirect:/noteList";
    }
}

