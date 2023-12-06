package com.example.BookStoreApp.service;

import com.example.BookStoreApp.dto.AuthorRequest;
import com.example.BookStoreApp.dto.AuthorResponse;
import com.example.BookStoreApp.dto.BookRequest;
import com.example.BookStoreApp.dto.BookResponse;
import com.example.BookStoreApp.entity.Author;

public interface AuthorService {

    Author createAuthor(Author author);

    BookResponse createBook(String username, BookRequest bookRequest);

    void deleteBook(Long id);




}
