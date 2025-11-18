package com.example.demo.repository;

import com.example.demo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    // Custom query: Fetch authors with their books (inner join)
    @Query("SELECT DISTINCT a FROM Author a JOIN FETCH a.books")
    List<Author> fetchAuthorsWithBooks();
}
