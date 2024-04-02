package dev.patika.library.dao;

import dev.patika.library.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo  extends JpaRepository<Author,Integer> {
}
