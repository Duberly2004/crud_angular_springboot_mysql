package com.example.api.models;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "course")
@Data //Genera los getters and setters
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;
}
