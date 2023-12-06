package com.example.BookStoreApp.repository;

import com.example.BookStoreApp.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {

    Author findByUserUsername(String username);
}
