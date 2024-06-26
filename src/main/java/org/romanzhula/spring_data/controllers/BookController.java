package org.romanzhula.spring_data.controllers;

import org.romanzhula.spring_data.models.Book;
import org.romanzhula.spring_data.services.BookService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/book")
public class BookController {
    private final BookService bookService;

    public BookController(
            BookService bookService
    ) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<?> createBook(
            @RequestBody Book book
    ) {
        return bookService.createBook(book);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> findAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping
    public ResponseEntity<Book> findBook(
            @RequestParam Long id
    ) {
        return bookService.getBook(id);
    }

    @GetMapping("/name")
    public ResponseEntity<Book> findByName(
            @RequestBody String name
    ) {
        return bookService.getByName(name);
    }

    @PutMapping
    public ResponseEntity<?> updateBook(
            @RequestBody Book book
    ) {
        return bookService.updateBook(book);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteBook(
            @RequestParam Long id
    ) {
        return bookService.deleteBook(id);
    }

    @GetMapping("/exist/name")
    public ResponseEntity<Boolean> existByName(
            @RequestBody String name
    ) {
        return bookService.existByName(name);
    }

    @GetMapping("/count/author")
    public ResponseEntity<Integer> countByAuthor(
            @RequestBody String author
    ) {
        return bookService.countByAuthor(author);
    }

    @DeleteMapping("/delete/name")
    public ResponseEntity<?> deleteByName(
            @RequestBody String name
    ) {
        return bookService.deleteByName(name);
    }

    @GetMapping("/found/4/author")
    public ResponseEntity<List<Book>> findFirst4ByAuthor(
            @RequestBody String author
    ) {
        return bookService.findFirst4ByAuthor(author);
    }

    @GetMapping("/find/distinct/author")
    public ResponseEntity<List<Book>> findDistinctByAuthor(
            @RequestBody String author
    ) {
        return bookService.findDistinctByAuthor(author);
    }

    @GetMapping("/exist/author/genre")
    public ResponseEntity<Boolean> existByAuthorAndGenre(
            @RequestBody Map<String, String> map
    ) {
        return bookService.existByAuthorAndGenre(map.get("author"), map.get("genre"));
    }

    @GetMapping("/find/name/author")
    public ResponseEntity<List<Book>> findByNameOrAuthor(
            @RequestBody Map<String, String> map
    ) {
        return bookService.findByNameOrAuthor(map.get("name"), map.get("author"));
    }

    @GetMapping("/count/name/containing")
    public ResponseEntity<Integer> countByNameContaining(
            @RequestBody String line
    ) {
        return bookService.countByNameContaining(line);
    }

    @GetMapping("/find/all/jpql")
    public ResponseEntity<List<Book>> findAllJPQL() {
        return bookService.findAllJPQL();
    }

    @GetMapping("/find/author")
    public ResponseEntity<List<Book>> findByAuthorName(
            @RequestBody String author
    ) {
        return bookService.findByAuthorName(author);
    }

    @GetMapping("/find/author/by/name/genre")
    public ResponseEntity<String> findAuthorByNameAndGenre(
            @RequestBody Map<String, String> map
    ) {
        return bookService.findAuthorByNameAndGenre(map.get("name"), map.get("genre"));
    }

    @GetMapping("/find/all/page")
    public ResponseEntity<Page<Book>> findAllPageable(
            @RequestBody Map<String, Integer> map
    ) {
        return bookService.findAllPageable(map.get("pageNumber"), map.get("size"));
    }

    @GetMapping("/find/all/sorted")
    public ResponseEntity<List<Book>> findAllSorted(
            @RequestBody Map<String, String> map
    ) {
        return bookService.findAllSorted(map.get("property"), map.get("way"));
    }

    @GetMapping("/find/all/pageable/sorted")
    public ResponseEntity<Page<Book>> findAllPageableAndSorted(
            @RequestBody Map<String, String> map
    ) {
        return bookService.findAllPageableAndSorted(
                Integer.valueOf(map.get("pageNumber")),
                Integer.valueOf(map.get("size")), map.get("property"), map.get("way")
        );
    }

}
