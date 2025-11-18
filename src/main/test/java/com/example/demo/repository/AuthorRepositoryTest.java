package com.example.demo.repository;

import com.example.demo.model.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void testFetchAuthorsWithBooks() {
        List<Author> authors = authorRepository.fetchAuthorsWithBooks();
        assertThat(authors).isNotNull();
        assertThat(authors.size()).isGreaterThan(0);
        // Optional: Assert authors have books loaded
        assertThat(authors.get(0).getBooks()).isNotEmpty();
    }
}
