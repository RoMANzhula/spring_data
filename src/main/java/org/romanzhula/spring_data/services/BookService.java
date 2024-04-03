package org.romanzhula.spring_data.services;

import org.romanzhula.spring_data.models.Book;
import org.romanzhula.spring_data.repositories.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public ResponseEntity<?> createBook(Book book) {
        bookRepository.save(book);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

}
