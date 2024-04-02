package dev.patika.library.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "authors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id",columnDefinition = "serial")
    private int id;

    @Column(name = "author_name",nullable = false)
    @NotNull
    private String name;

    @Column(name = "author_birthday",nullable = false)
    @NotNull
    private LocalDate birthday;

    @Column(name = "author_country")
    @NotNull
    private String country;




}
