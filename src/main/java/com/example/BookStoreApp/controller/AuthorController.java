package com.example.BookStoreApp.controller;

import com.example.BookStoreApp.dto.*;
import com.example.BookStoreApp.service.impl.AuthorServiceImpl;
import com.example.BookStoreApp.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorServiceImpl service;


    @PostMapping()
    public ResponseEntity<BookResponse> createBook(
            @RequestBody BookRequest bookRequest,
            @AuthenticationPrincipal UserDetails userDetails) {

        String username = userDetails.getUsername();

        BookResponse response = service.createBook(username,bookRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }



}
