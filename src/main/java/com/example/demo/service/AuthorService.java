package com.example.demo.service;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    // Create new author
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    // Read all authors
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // Update existing author
    public Author updateAuthor(Long id, Author updatedAuthor) {
        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Author not found with id " + id));
        existingAuthor.setName(updatedAuthor.getName());
        existingAuthor.setNationality(updatedAuthor.getNationality());
        existingAuthor.setBirthYear(updatedAuthor.getBirthYear());
        return authorRepository.save(existingAuthor);
    }

    // Custom fetch authors with books
    public List<Author> fetchAuthorsWithBooks() {
        return authorRepository.fetchAuthorsWithBooks();
    }
}
