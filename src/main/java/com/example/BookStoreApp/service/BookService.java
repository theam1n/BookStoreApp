package com.example.BookStoreApp.service;

import com.example.BookStoreApp.dto.StudentResponse;

import java.util.List;

public interface BookService {

    List<StudentResponse> getAllReaders(Long id);


}
