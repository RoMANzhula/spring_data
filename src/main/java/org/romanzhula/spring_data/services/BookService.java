package org.romanzhula.spring_data.services;

import org.romanzhula.spring_data.models.Book;
import org.romanzhula.spring_data.repositories.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Transactional(readOnly = true)
    public ResponseEntity<Book> getBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            return ResponseEntity.ok(optionalBook.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Book> getByName(String name) {
        Optional<Book> optionalBook = bookRepository.findByName(name);

        if (optionalBook.isPresent()) {
            return ResponseEntity.ok(optionalBook.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Transactional
    public ResponseEntity<?> updateBook(Book book) {
        Optional<Book> optionalBook = bookRepository.findById(book.getId());

        if (optionalBook.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        bookRepository.save(book);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Transactional
    public ResponseEntity<?> deleteBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        bookRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Boolean> existByName(String name) {
        return ResponseEntity.ok(bookRepository.existByName(name));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Integer> countByAuthor(String author) {
        return ResponseEntity.ok(bookRepository.countByAuthor(author));
    }

    @Transactional
    public ResponseEntity<?> deleteByName(String name) {
        if (bookRepository.existByName(name)) {
            bookRepository.deleteByName(name);

            return ResponseEntity.status(HttpStatus.OK).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<Book>> findFirst4ByAuthor(String author) {
        return ResponseEntity.ok(bookRepository.findFirst4ByAuthor(author));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<Book>> findDistinctByAuthor(String author) {
        return ResponseEntity.ok(bookRepository.findDistinctByAuthor(author));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Boolean> existByAuthorAndGenre(String author, String genre) {
        return ResponseEntity.ok(bookRepository.existsByAuthorAAndGenre(author, genre));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<Book>> findByNameOrAuthor(String name, String author) {
        return ResponseEntity.ok(bookRepository.findByNameOrAuthor(name, author));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Integer> countByNameContaining(String line) {
        return ResponseEntity.ok(bookRepository.countByNameContaining(line));
    }

}
