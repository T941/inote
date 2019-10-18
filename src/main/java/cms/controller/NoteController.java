package cms.controller;

import cms.model.Note;
import cms.model.NoteType;
import cms.service.NoteService;
import cms.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;
    @Autowired
    private NoteTypeService noteTypeService;

    @ModelAttribute("types")
    public Iterable<NoteType> noteTypes(){
        return noteTypeService.findAll();
    }


    @GetMapping("/create-note")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/note/create");
        modelAndView.addObject("note", new Note());
        return modelAndView;
    }
    @PostMapping("/create-note")
    public ModelAndView saveCustomer(@ModelAttribute Note note){
        noteService.save(note);

        ModelAndView modelAndView = new ModelAndView("/note/create");
        modelAndView.addObject("note", new Note());
        modelAndView.addObject("message", "New note created successfully");
        return modelAndView;
    }
    @GetMapping("/notes")
    public ModelAndView listEmployee(@RequestParam("s") Optional<String> s, @PageableDefault(value = 3) Pageable pageable){
        Page<Note> notes;
        if(s.isPresent()){
            notes = noteService.findAllByTitleContaining(s.get(), pageable);
        } else {
            notes = noteService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/note/list");
        modelAndView.addObject("notes", notes);
        return modelAndView;
    }
    @GetMapping("/edit-note/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Note note = noteService.findById(id);
        if(note != null) {
            ModelAndView modelAndView = new ModelAndView("/note/edit");
            modelAndView.addObject("note", note);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-note")
    public String updateNote(@ModelAttribute Note note){
        noteService.save(note);

        return "redirect:notes";
    }
    @GetMapping("/delete-note/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Note note = noteService.findById(id);
        if(note != null) {
            ModelAndView modelAndView = new ModelAndView("/note/delete");
            modelAndView.addObject("note", note);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-note")
    public String deleteCustomer(@ModelAttribute Note note){
        noteService.delete(note.getId());
        return "redirect:notes";
    }

}
