package com.example.api.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api.models.StudentCourse;

public interface StudentCourseRepository extends JpaRepository<StudentCourse,Integer> {}
