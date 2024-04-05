package org.romanzhula.spring_data.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.romanzhula.spring_data.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void findByNameTest() {
        Book book = new Book(
                null,
                "testBook",
                "testGenre",
                new Date(),
                "testAuthor"
        );

        entityManager.persist(book);
        entityManager.flush();

        Optional<Book> optionalFound = bookRepository.findByName(book.getName());

        assertTrue(optionalFound.isPresent());

        Book found = optionalFound.get();

        assertEquals(book.getName(), found.getName());
        assertEquals(book.getGenre(), found.getGenre());
        assertEquals(book.getDate(), found.getDate());
        assertEquals(book.getAuthor(), found.getAuthor());
    }

    @Test
    public void findByNameNegativeTest() {
        Book book = new Book(
                null,
                "testBook",
                "testGenre",
                new Date(),
                "testAuthor"
        );

        entityManager.persist(book);
        entityManager.flush();

        Optional<Book> optionalFound = bookRepository.findByName("book");

        assertFalse(optionalFound.isPresent());

    }

}