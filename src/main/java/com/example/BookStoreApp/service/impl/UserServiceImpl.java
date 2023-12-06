package com.example.BookStoreApp.service.impl;

import com.example.BookStoreApp.dto.*;
import com.example.BookStoreApp.entity.Author;
import com.example.BookStoreApp.entity.Role;
import com.example.BookStoreApp.entity.Student;
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

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final AuthorServiceImpl authorService;
    private final StudentServiceImpl studentService;
    @Override
    public UserResponse saveUser(UserRequest userRequest) {

        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        var user = mapper.requestToEntity(userRequest);
        var response = mapper.entityToResponse(repository.save(user));

        Set<Role> roles = user.getRoles();

        for (Role role : roles) {
            if (role.getId() == 2) {
                Author author = new Author();
                author.setName(user.getName());
                author.setSurname(user.getSurname());
                author.setAge(user.getAge());
                author.setUser(user);
               authorService.createAuthor(author);
            }
            if (role.getId() == 3) {
                Student student = new Student();
                student.setName(user.getName());
                student.setSurname(user.getSurname());
                student.setAge(user.getAge());
                student.setUser(user);
                studentService.createStudent(student);
            }
        }


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
