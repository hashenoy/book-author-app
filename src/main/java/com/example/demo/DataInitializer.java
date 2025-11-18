package com.example.demo;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        // Clear existing data
        bookRepository.deleteAll();
        authorRepository.deleteAll();

        // Sample authors
        Author a1 = new Author("Jane Austen", "British", 1775);
        Author a2 = new Author("Mark Twain", "American", 1835);
        Author a3 = new Author("Charles Dickens", "British", 1812);
        Author a4 = new Author("Leo Tolstoy", "Russian", 1828);
        Author a5 = new Author("Fyodor Dostoevsky", "Russian", 1821);
        Author a6 = new Author("Herman Melville", "American", 1819);
        Author a7 = new Author("Virginia Woolf", "British", 1882);
        Author a8 = new Author("Gabriel García Márquez", "Colombian", 1927);
        Author a9 = new Author("George Orwell", "British", 1903);
        Author a10 = new Author("Jules Verne", "French", 1828);

        authorRepository.save(a1);
        authorRepository.save(a2);
        authorRepository.save(a3);
        authorRepository.save(a4);
        authorRepository.save(a5);
        authorRepository.save(a6);
        authorRepository.save(a7);
        authorRepository.save(a8);
        authorRepository.save(a9);
        authorRepository.save(a10);

        // Sample books
        bookRepository.save(new Book("Pride and Prejudice", "Novel", 1813, a1));
        bookRepository.save(new Book("Adventures of Huckleberry Finn", "Novel", 1884, a2));
        bookRepository.save(new Book("Great Expectations", "Novel", 1861, a3));
        bookRepository.save(new Book("War and Peace", "Historical Novel", 1869, a4));
        bookRepository.save(new Book("Crime and Punishment", "Philosophical Novel", 1866, a5));
        bookRepository.save(new Book("Moby-Dick", "Adventure", 1851, a6));
        bookRepository.save(new Book("Mrs Dalloway", "Modernism", 1925, a7));
        bookRepository.save(new Book("One Hundred Years of Solitude", "Magic Realism", 1967, a8));
        bookRepository.save(new Book("1984", "Dystopian", 1949, a9));
        bookRepository.save(new Book("Journey to the Center of the Earth", "Science Fiction", 1864, a10));
    }
}
