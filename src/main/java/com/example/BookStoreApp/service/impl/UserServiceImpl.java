package com.example.BookStoreApp.service.impl;

import com.example.BookStoreApp.dto.LoginRequest;
import com.example.BookStoreApp.dto.LoginResponse;
import com.example.BookStoreApp.dto.UserRequest;
import com.example.BookStoreApp.dto.UserResponse;
import com.example.BookStoreApp.entity.User;
import com.example.BookStoreApp.mapper.UserMapper;
import com.example.BookStoreApp.repository.UserRepository;
import com.example.BookStoreApp.service.UserService;
import com.example.BookStoreApp.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public UserResponse saveUser(UserRequest userRequest) {

        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        var user = mapper.requestToEntity(userRequest);
        var response = mapper.entityToResponse(repository.save(user));

        return response;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                loginRequest.getPassword()));

        User user =  repository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.generateToken(user);

        return LoginResponse.builder()
                .token(token)
                .build();
    }


}
