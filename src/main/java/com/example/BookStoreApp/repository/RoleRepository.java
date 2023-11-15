package com.example.BookStoreApp.repository;

import com.example.BookStoreApp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
