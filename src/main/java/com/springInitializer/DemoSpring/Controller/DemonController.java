package com.springInitializer.DemoSpring.Controller;

import com.springInitializer.DemoSpring.Entity.Demon;
import com.springInitializer.DemoSpring.Service.DemonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/demon")
public class DemonController {

    @Autowired
    private DemonService demonService;

    @GetMapping("/Hello")
    //all of them return String, it returns html, so it should return string.
    public String hello() {
        return "Hello";
    }

    @GetMapping("/")
    public String displayAllDemons(Model model) {
        List<Demon> demon = demonService.getAllDemons();
        model.addAttribute("demon", demon);
        return "listOfDemons";
    }

    @GetMapping("/add")
    public String addDemon(Model model) {
        model.addAttribute("demon", new Demon());
        return "addDemon";
    }

    @PostMapping("/add")
    public String addDemon(@ModelAttribute("demon") @Valid Demon demon, Errors errors) {
        if (errors.hasErrors()) {
            return "addDemon";
        }
        demonService.saveDemon(demon);
        return "redirect:/demon/";
    }

    @GetMapping("/edit/{id}")
    public String updateDemon(@PathVariable Long id, Model model) {

        Demon demon = demonService.getDemonById(id);
        model.addAttribute("demon", demon);
        return "editDemon";
    }

    @PostMapping("/edit/{id}")
    public String updateDemon(@PathVariable Long id, @ModelAttribute("demon") @Valid Demon demon, Errors errors) {
        if (errors.hasErrors()) {
            return "editDemon";
        }
        demonService.updateDemon(demon, id);
        return "redirect:/demon/";
    }

        @GetMapping("/delete/{id}")
        public String deleteDemon(@PathVariable Long id){
            demonService.deleteDemonById(id);
            return "redirect:/demon/";

        }


    }





