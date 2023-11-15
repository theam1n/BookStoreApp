package com.example.BookStoreApp.service.impl;

import com.example.BookStoreApp.dto.BookRequest;
import com.example.BookStoreApp.dto.BookResponse;
import com.example.BookStoreApp.entity.Book;
import com.example.BookStoreApp.entity.Student;
import com.example.BookStoreApp.mapper.AuthorMapper;
import com.example.BookStoreApp.mapper.BookMapper;
import com.example.BookStoreApp.mapper.StudentMapper;
import com.example.BookStoreApp.repository.BookRepository;
import com.example.BookStoreApp.repository.StudentRepository;
import com.example.BookStoreApp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final AuthorMapper authorMapper;
    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    @Override
    public List<Book> getAllReadingBooks(Long id) {
        return null;
    }

    @Override
    public BookResponse getBook(Long id, BookRequest bookRequest) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        Student student = optionalStudent.get();


        Book book = bookRepository.findByName(bookMapper.requestToEntity(bookRequest).getName());

        student.getBooks().add(book);
        studentRepository.save(student);

        BookResponse response = bookMapper.entityToResponse(book);
        response.setAuthor(authorMapper.entityToResponse(book.getAuthor()));

        return response;
    }




    @Override
    public void subscribe(Long id) {

    }
}
