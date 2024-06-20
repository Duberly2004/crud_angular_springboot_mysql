package com.example.api.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api.models.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {}