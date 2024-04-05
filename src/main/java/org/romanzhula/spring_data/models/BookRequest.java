package org.romanzhula.spring_data.models;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "book_requests")
public class BookRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "reader_id", nullable = false)
    private Reader reader;

    @OneToMany(mappedBy = "reader")
    private Set<BookRequest> requests;

    public BookRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Set<BookRequest> getRequests() {
        return requests;
    }

    public void setRequests(Set<BookRequest> requests) {
        this.requests = requests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookRequest that = (BookRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(reader, that.reader) && Objects.equals(requests, that.requests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, reader, requests);
    }
}
