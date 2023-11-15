package com.example.BookStoreApp.controller;

import com.example.BookStoreApp.dto.*;
import com.example.BookStoreApp.service.impl.AuthorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorServiceImpl service;

    @PostMapping("/{id}")
    public ResponseEntity<BookResponse> createBook(@PathVariable Long id, @RequestBody BookRequest bookRequest) {
        BookResponse response = service.createBook(id, bookRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}
