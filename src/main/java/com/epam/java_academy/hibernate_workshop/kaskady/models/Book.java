package com.epam.java_academy.hibernate_workshop.kaskady.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BOOKS", uniqueConstraints = {@UniqueConstraint(columnNames = "BOOK_ID")})
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "TITLE", nullable = false, length = 100)
    private String title;

    @ManyToOne
    @JoinColumn(name="AUTHOR_ID")
    private Author author;

    public Book() {
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}