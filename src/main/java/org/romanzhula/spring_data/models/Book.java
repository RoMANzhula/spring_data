package org.romanzhula.spring_data.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "books")
@NamedQuery(name = "Book.findByAuthorName", query = "SELECT book FROM Book book WHERE book.author = ? 1")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "genre")
    private String genre;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "author")
    private String author;

    public Book() {
    }

    public Book(Long id, String name, String genre, Date date, String author) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.date = date;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
