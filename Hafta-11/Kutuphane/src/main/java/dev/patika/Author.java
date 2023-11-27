package dev.patika;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", columnDefinition =  "serial")
    private int id;

    @Column(name = "author_name", length = 100, nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private LocalDate date;

    @Column(name = "country", length = 100, nullable = false )
    private String country;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    private List<Book> bookList;


    public Author() {
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
