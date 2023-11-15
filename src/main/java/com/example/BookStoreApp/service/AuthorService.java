package com.example.BookStoreApp.service;

import com.example.BookStoreApp.dto.AuthorRequest;
import com.example.BookStoreApp.dto.AuthorResponse;
import com.example.BookStoreApp.dto.BookRequest;
import com.example.BookStoreApp.dto.BookResponse;

public interface AuthorService {

    BookResponse createBook(Long id, BookRequest bookRequest);

    void deleteBook(Long id);


}
