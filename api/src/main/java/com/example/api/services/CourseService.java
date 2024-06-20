package com.example.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.interfaces.CourseInterface;
import com.example.api.models.Course;
import com.example.api.repositories.CourseRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CourseService implements CourseInterface {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> list() {
        return courseRepository.findAll();
    }

    @Override
    public Course getForId(int id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        return optionalCourse.orElse(null);  // Manejo correcto de Optional
    }

    @Override
    public Course add(Course c) {
        return courseRepository.save(c);
    }

    @Override
    public Course update(Course c) {
        if (courseRepository.existsById(c.getId())) {
            return courseRepository.save(c);
        } else {
            throw new EntityNotFoundException("No se encontró la Course con ID: " + c.getId());
        }
    }

    @Override
    public Course delete(int id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            courseRepository.delete(optionalCourse.get());
            return optionalCourse.get();
        } else {
            return null;  // O lanzar una excepción si es necesario
        }
    }
}
