package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Create new book
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // Read all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Update existing book
    public Book updateBook(Long id, Book updatedBook) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Book not found with id " + id));
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setGenre(updatedBook.getGenre());
        existingBook.setPublishedYear(updatedBook.getPublishedYear());
        existingBook.setAuthor(updatedBook.getAuthor());
        return bookRepository.save(existingBook);
    }

    // Custom fetch books with authors
    public List<Book> fetchBooksWithAuthors() {
        return bookRepository.fetchBooksWithAuthors();
    }
}
