package com.example.demo.service;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.BeforeEach;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateAuthor() {
        Author author = new Author("Test Author", "Test Country", 1900);
        when(authorRepository.save(author)).thenReturn(author);

        Author created = authorService.createAuthor(author);

        assertEquals("Test Author", created.getName());
        verify(authorRepository, times(1)).save(author);
    }

    @Test
    public void testUpdateAuthor() {
        Long id = 1L;
        Author existing = new Author("Old Name", "Old Country", 1850);
        existing.setId(id);
        Author updated = new Author("New Name", "New Country", 1900);
        when(authorRepository.findById(id)).thenReturn(Optional.of(existing));
        when(authorRepository.save(existing)).thenReturn(existing);

        Author result = authorService.updateAuthor(id, updated);

        assertEquals("New Name", result.getName());
        assertEquals("New Country", result.getNationality());
        assertEquals(1900, result.getBirthYear());
        verify(authorRepository).findById(id);
        verify(authorRepository).save(existing);
    }
}
