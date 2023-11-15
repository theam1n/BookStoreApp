package com.example.BookStoreApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;


    @ManyToMany(cascade = {CascadeType.MERGE},
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_book",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.MERGE},
    fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_author",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> subscribedAuthors = new HashSet<>();

}
