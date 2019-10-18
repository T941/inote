package cms.controller;

import cms.model.NoteType;
import cms.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class NoteTypeController {
    @Autowired
    private NoteTypeService noteTypeService;

    @GetMapping("/types")
    public ModelAndView listProvinces(){
        Iterable<NoteType> noteTypes = noteTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/type/list");
        modelAndView.addObject("types", noteTypes);
        return modelAndView;
    }

    @GetMapping("/create-type")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/type/create");
        modelAndView.addObject("type", new NoteType());
        return modelAndView;
    }

    @PostMapping("/create-type")
    public ModelAndView saveProvince(@ModelAttribute NoteType noteType){
        noteTypeService.save(noteType);

        ModelAndView modelAndView = new ModelAndView("/type/create");
        modelAndView.addObject("type", new NoteType());
        modelAndView.addObject("message", "New type created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-type/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        NoteType noteType = noteTypeService.findById(id);
        if(noteType != null) {
            ModelAndView modelAndView = new ModelAndView("/type/edit");
            modelAndView.addObject("type", noteType);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-type")
    public String updateProvince(@ModelAttribute NoteType noteType){
        noteTypeService.save(noteType);
        return "redirect:types";
    }

    @GetMapping("/delete-type/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        NoteType noteType = noteTypeService.findById(id);
        if(noteType != null) {
            ModelAndView modelAndView = new ModelAndView("/type/delete");
            modelAndView.addObject("type", noteType);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-type")
    public String deleteProvince(@ModelAttribute NoteType noteType){
        noteTypeService.delete(noteType.getId());
        return "redirect:types";
    }

}
