package dev.patika;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "categories")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", columnDefinition =  "serial")
    private int id;

    @Column(name = "category_name", length = 100, nullable = false)
    private String name;


    @Column(name = "category_description", length = 300, nullable = false )
    private String category;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "category2book",
            joinColumns = {
                    @JoinColumn(name = "category2book_category_id")
            },
            inverseJoinColumns = {@JoinColumn(name = "category2book_book_id")}
    )
    private List<Book> bookList;
    public Category() {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
