package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    // Show form to add new author
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("author", new Author());
        return "author-add";
    }

    // Handle author creation form submission
    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Author author, Model model) {
        try {
            authorService.createAuthor(author);
            return "redirect:/authors/list";
        } catch (Exception e) {
            model.addAttribute("error", "Error creating author: " + e.getMessage());
            return "author-add";
        }
    }

    // List all authors
    @GetMapping("/list")
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "author-list";
    }

    // Show form to edit author
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Author author = authorService.getAllAuthors().stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElse(null);
        model.addAttribute("author", author);
        return "author-edit";
    }

    // Handle author update form submission
    @PostMapping("/edit/{id}")
    public String updateAuthor(@PathVariable Long id, @ModelAttribute Author author) {
        authorService.updateAuthor(id, author);
        return "redirect:/authors/list";
    }
}
