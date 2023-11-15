package com.example.BookStoreApp.service.impl;

import com.example.BookStoreApp.dto.StudentResponse;
import com.example.BookStoreApp.mapper.BookMapper;
import com.example.BookStoreApp.repository.BookRepository;
import com.example.BookStoreApp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final BookMapper mapper;


    @Override
    public List<StudentResponse> getAllReaders(Long id) {
        return null;
    }
}
