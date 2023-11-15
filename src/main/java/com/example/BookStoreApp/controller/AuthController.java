package com.example.BookStoreApp.controller;

import com.example.BookStoreApp.dto.*;
import com.example.BookStoreApp.service.impl.UserServiceImpl;
import com.example.BookStoreApp.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserServiceImpl userService;
    private final JwtService jwtService;



    @PostMapping("/register")
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserRequest request) {
        UserResponse response = userService.saveUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {

        LoginResponse response = userService.login(request);
        return ResponseEntity.ok(response);
    }






}
