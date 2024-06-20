package com.example.api.models;
import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "student_course")
@Data //Genera los getters and setters
public class StudentCourse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;
}
