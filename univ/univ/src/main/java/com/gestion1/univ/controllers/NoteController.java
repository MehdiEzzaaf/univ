package com.gestion1.univ.controllers;



import com.gestion1.univ.entitites.Note;
import com.gestion1.univ.services.Noteservice;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class NoteController {

    @Autowired
    private Noteservice noteService;

    @RequestMapping("/createNote")
    public String createNote(ModelMap model) {
        model.addAttribute("noteVue", new Note());
        return "CreateNote";
    }

    @RequestMapping(value = "/saveNote", method = RequestMethod.POST)
    public String saveNote(@ModelAttribute("noteVue") Note note) {
        noteService.saveNote(note);
        return "redirect:/noteList";
    }

    @RequestMapping("/noteList")
    public String noteList(ModelMap modelMap) {
        List<Note> notes = noteService.getAllNotes();
        modelMap.addAttribute("notesVue", notes);
        return "NoteList";
    }

    @RequestMapping("/deleteNote")
    public String deleteNote(@RequestParam("id") Long idNote) {
        noteService.deleteNoteById(idNote);
        return "redirect:/noteList";
    }

    @RequestMapping("/editNote")
    public String editNote(@RequestParam("id") Long idNote, ModelMap modelMap) {
        Note note = noteService.getNoteById(idNote);
        modelMap.addAttribute("noteVue", note);
        return "EditNote";
    }

    @RequestMapping(value = "/updateNote", method = RequestMethod.POST)
    public String updateNote(@ModelAttribute("noteVue") Note note) {
        noteService.updateNote(note);
        return "redirect:/noteList";
    }
}

