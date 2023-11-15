package com.example.BookStoreApp.repository;

import com.example.BookStoreApp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
