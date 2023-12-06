package com.example.BookStoreApp.service;

import com.example.BookStoreApp.dto.*;
import com.example.BookStoreApp.entity.Book;
import com.example.BookStoreApp.entity.Student;

import java.util.List;

public interface StudentService {


    Student createStudent(Student student);
    List<Book> getAllReadingBooks(Long id);

    BookResponse getBook(Long id,BookRequest bookRequest );

    void subscribe(Long id);





}
