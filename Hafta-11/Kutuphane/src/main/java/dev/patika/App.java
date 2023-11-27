package dev.patika;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.concurrent.Flow;


public class App {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("kutuphane");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        Category category = new Category();
        category.setName("Romantizm");
        category.setCategory("..");
        entityManager.persist(category);

        Publisher publisher = new Publisher();
        publisher.setAddress("Ankara");
        publisher.setName("Işık Yayınevi");
        publisher.setDate(LocalDate.of(1998, 11, 2));
        entityManager.persist(publisher);

        Author author = new Author();
        author.setCountry("İstanbul");
        author.setName("Esma");
        author.setDate(LocalDate.of(1975, 02, 01));
        entityManager.persist(author);

        Book book = new Book();
        book.setName("Kıvılcım");
        book.setStock(108);
        book.setDate(LocalDate.of(2023, 10, 12));
        book.setAuthor(author);
        book.setPublisher(publisher);
        entityManager.persist(book);

        BookBorrowing borrower = new BookBorrowing();
        borrower.setDate(LocalDate.of(2023, 07, 17));
        borrower.setReturnDate(LocalDate.of(2023, 12, 18));
        borrower.setName("Kılıç");
        borrower.setBook(book);
        entityManager.persist(borrower);


        transaction.commit();


    }
}