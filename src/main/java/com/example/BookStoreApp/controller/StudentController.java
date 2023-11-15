package com.example.BookStoreApp.controller;


import com.example.BookStoreApp.dto.BookRequest;
import com.example.BookStoreApp.dto.BookResponse;
import com.example.BookStoreApp.dto.StudentRequest;
import com.example.BookStoreApp.dto.StudentResponse;
import com.example.BookStoreApp.entity.Book;
import com.example.BookStoreApp.service.impl.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentServiceImpl service;


    @PostMapping("/book/{id}")
    public ResponseEntity<BookResponse> getBook(@PathVariable Long id,
                                                @RequestBody BookRequest bookRequest) {

        BookResponse response = service.getBook(id, bookRequest);
        return ResponseEntity.ok(response);
    }






}
