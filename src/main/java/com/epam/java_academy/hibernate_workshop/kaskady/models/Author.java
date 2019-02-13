package com.epam.java_academy.hibernate_workshop.kaskady.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "AUTHORS")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID", unique = true, nullable = true)
    private int authorId;

    @Column(name = "AUTHOR_NAME", nullable = true, length = 250)
    private String authorName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Book> books;

    public Author() {
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
