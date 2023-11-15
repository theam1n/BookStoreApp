package com.example.BookStoreApp.service;

import com.example.BookStoreApp.dto.LoginRequest;
import com.example.BookStoreApp.dto.LoginResponse;
import com.example.BookStoreApp.dto.UserRequest;
import com.example.BookStoreApp.dto.UserResponse;
import com.example.BookStoreApp.entity.User;

public interface UserService {

    UserResponse saveUser(UserRequest userRequest);
    LoginResponse login(LoginRequest loginRequest);
}
