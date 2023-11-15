package com.example.BookStoreApp.service.impl;

import com.example.BookStoreApp.dto.AuthorRequest;
import com.example.BookStoreApp.dto.AuthorResponse;
import com.example.BookStoreApp.dto.BookRequest;
import com.example.BookStoreApp.dto.BookResponse;
import com.example.BookStoreApp.entity.Author;
import com.example.BookStoreApp.entity.Book;
import com.example.BookStoreApp.mapper.AuthorMapper;
import com.example.BookStoreApp.mapper.BookMapper;
import com.example.BookStoreApp.repository.AuthorRepository;
import com.example.BookStoreApp.repository.BookRepository;
import com.example.BookStoreApp.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;


    @Override
    public BookResponse createBook(Long id, BookRequest bookRequest) {

        Optional<Author> optionalAuthor = authorRepository.findById(id);
        Author author = optionalAuthor.get();

        Book book = bookMapper.requestToEntity(bookRequest);
        book.setAuthor(author);
        bookRepository.save(book);

       return bookMapper.entityToResponse(book);

    }

    @Override
    public void deleteBook(Long id) {

    }
}
