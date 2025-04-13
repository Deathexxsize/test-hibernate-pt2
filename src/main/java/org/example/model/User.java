package org.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String email;
    private String username;

    public User(String name, int age, String email, String username) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.username = username;
    }
}
