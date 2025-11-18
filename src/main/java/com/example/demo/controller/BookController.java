package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.example.demo.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    // Show form to add new book
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "book-add";
    }

    // Handle new book form submission
    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book, Model model) {
        try {
            bookService.createBook(book);
            return "redirect:/books/list";
        } catch (Exception e) {
            model.addAttribute("error", "Error creating book: " + e.getMessage());
            model.addAttribute("authors", authorService.getAllAuthors());
            return "book-add";
        }
    }

    // List all books
    @GetMapping("/list")
    public String listBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book-list";
    }

    // Show form to edit a book
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Book book = bookService.getAllBooks().stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);
        model.addAttribute("book", book);
        model.addAttribute("authors", authorService.getAllAuthors());
        return "book-edit";
    }

    // Handle book update form submission
    @PostMapping("/edit/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute Book book, Model model) {
        try {
            bookService.updateBook(id, book);
            return "redirect:/books/list";
        } catch (Exception e) {
            model.addAttribute("error", "Error updating book: " + e.getMessage());
            model.addAttribute("authors", authorService.getAllAuthors());
            return "book-edit";
        }
    }
}
