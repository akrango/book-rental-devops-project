package org.example.emtlab_a.web;

import org.example.emtlab_a.model.Author;
import org.example.emtlab_a.model.Country;
import org.example.emtlab_a.service.AuthorService;
import org.example.emtlab_a.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final CountryService countryService;

    public AuthorController(AuthorService authorService, CountryService countryService) {
        this.authorService = authorService;
        this.countryService = countryService;
    }

    @GetMapping
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("bodyContent", "authors");
        return "master-template";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("coutries", countryService.findAll());
        model.addAttribute("bodyContent", "add-authors");
        return "master-template";
    }

    @GetMapping("/edit/{id}")
    public String add(@PathVariable Long id,
                      Model model) {
        model.addAttribute("author", authorService.findById(id).get());
        model.addAttribute("coutries", countryService.findAll());
        model.addAttribute("bodyContent", "add-authors");
        return "master-template";
    }


    @PostMapping("/save")
    public String editAuhtor(
            @RequestParam(required = false) Long id,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam Long country) {

        if (id != null) {
            this.authorService.edit(id, name, surname, country);
        } else {
            this.authorService.save(name, surname, country);
        }
        return "redirect:/authors";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        this.authorService.delete(id);
        return "redirect:/authors";
    }
}
