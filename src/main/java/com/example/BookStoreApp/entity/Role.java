package com.example.BookStoreApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

//    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST},
//            fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "role_user",
//            joinColumns = @JoinColumn(name = "role_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
//

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

}
