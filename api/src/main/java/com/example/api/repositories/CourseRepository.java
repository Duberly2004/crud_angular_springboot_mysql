package com.example.api.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api.models.Course;

public interface CourseRepository extends JpaRepository<Course,Integer>{}