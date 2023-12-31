package com.example.BookStoreApp.dto;


import com.example.BookStoreApp.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String name;

    private String surname;

    private int age;

    private String email;

    private String username;

    private String password;

    private Set<RoleDto> roles;
}
