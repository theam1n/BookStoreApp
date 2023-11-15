package com.example.BookStoreApp.dto;

import com.example.BookStoreApp.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {

    private String name;
    private AuthorRequest authorRequest;



}
