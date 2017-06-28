package org.rafalpieniazek.books.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import org.rafalpieniazek.books.common.Genre;

@Entity
public class Book implements Serializable {

    public static final String TITLE_PROPERTY = "title";

    public static final String AUTHORS = "authors";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "BOOK_AUTHOR", joinColumns = {
            @JoinColumn(name = "BOOK_ID", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "AUTHOR_ID", nullable = false, updatable = false)})
    private Set<Author> authors = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "book")
    private BookReview bookReview;

    @ManyToOne
    @JoinColumn(name = "LIBRARY_ID", nullable = true)
    private Library library;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(name = "book_year")
    private int year;

    @Version
    private long version;

    // for hibernate
    public Book() {
    }

    public Book(String title) {
        setTitle(title);
    }

    public Book(Long id, String title) {
        this(title);
        setId(id);
    }

    public void addAuthor(Author author) {

        this.authors.add(author);
    }

    public String getTitle() {

        return this.title;
    }

    public Set<Author> getAuthors() {

        return this.authors;
    }

    public void setAuthors(Set<Author> authors) {

        this.authors = authors;
    }

    public BookReview getBookReview() {

        return this.bookReview;
    }

    public void setBookReview(BookReview bookReview) {

        if (bookReview != null) {
            bookReview.setBook(this);
        }
    }

    public int getYear() {

        return this.year;
    }

    public void setYear(int year) {

        this.year = year;
    }

    public long getVersion() {

        return this.version;
    }

    public void setVersion(long version) {

        this.version = version;
    }

    public Library getLibrary() {

        return this.library;
    }

    public void setLibrary(Library library) {

        this.library = library;
    }

    public Genre getGenre() {

        return this.genre;
    }

    public void setGenre(Genre genre) {

        this.genre = genre;
    }

    public Long getId() {

        return this.id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public void setTitle(String title) {

        this.title = title;
    }
}
