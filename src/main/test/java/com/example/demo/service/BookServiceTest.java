package com.example.demo.service;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateBook() {
        Author author = new Author("Author", "Country", 1900);
        Book book = new Book("Title", "Genre", 2000, author);
        when(bookRepository.save(book)).thenReturn(book);

        Book created = bookService.createBook(book);

        assertEquals("Title", created.getTitle());
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    public void testUpdateBook() {
        Long id = 1L;
        Author authorOld = new Author("Old Author", "Old", 1850);
        Author authorNew = new Author("New Author", "New", 1900);

        Book existing = new Book("Old Title", "Old Genre", 1900, authorOld);
        existing.setId(id);

        Book updated = new Book("New Title", "New Genre", 2000, authorNew);

        when(bookRepository.findById(id)).thenReturn(Optional.of(existing));
        when(bookRepository.save(existing)).thenReturn(existing);

        Book result = bookService.updateBook(id, updated);

        assertEquals("New Title", result.getTitle());
        assertEquals("New Genre", result.getGenre());
        assertEquals(2000, result.getPublishedYear());
        assertEquals("New Author", result.getAuthor().getName());

        verify(bookRepository).findById(id);
        verify(bookRepository).save(existing);
    }
}
