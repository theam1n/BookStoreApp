package com.example.BookStoreApp.service;

import com.example.BookStoreApp.dto.*;
import com.example.BookStoreApp.entity.Book;

import java.util.List;

public interface StudentService {


    List<Book> getAllReadingBooks(Long id);

    BookResponse getBook(Long id,BookRequest bookRequest );

    void subscribe(Long id);





}
