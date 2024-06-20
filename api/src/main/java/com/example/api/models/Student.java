package com.example.api.models;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "student")
@Data //Genera los getters and setters
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "email", nullable = false)
    private String email;
}
