package org.romanzhula.spring_data.controllers;

import org.romanzhula.spring_data.models.Book;
import org.romanzhula.spring_data.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }



    @GetMapping
    public ResponseEntity<Book> getBook(@RequestParam Long id) {
        return bookService.getBook(id);
    }

    @GetMapping("/name")
    public ResponseEntity<Book> getByName(@RequestBody String name) {
        return bookService.getByName(name);
    }

    @PutMapping
    public ResponseEntity<?> updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteBook(@RequestParam Long id) {
        return bookService.deleteBook(id);
    }


}
