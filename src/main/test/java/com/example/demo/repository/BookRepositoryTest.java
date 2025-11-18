package com.example.demo.repository;

import com.example.demo.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testFetchBooksWithAuthors() {
        List<Book> books = bookRepository.fetchBooksWithAuthors();
        assertThat(books).isNotNull();
        assertThat(books.size()).isGreaterThan(0);
        // Optional: Assert each book has an author
        assertThat(books.get(0).getAuthor()).isNotNull();
    }
}
