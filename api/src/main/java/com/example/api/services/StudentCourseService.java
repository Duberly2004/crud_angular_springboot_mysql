package com.example.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.interfaces.StudentCourseInterface;
import com.example.api.models.StudentCourse;
import com.example.api.repositories.StudentCourseRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentCourseService implements StudentCourseInterface {

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Override
    public List<StudentCourse> list() {
        return studentCourseRepository.findAll();
    }

    @Override
    public StudentCourse getForId(int id) {
        Optional<StudentCourse> optionalStudentCourse = studentCourseRepository.findById(id);
        return optionalStudentCourse.orElse(null);  // Manejo correcto de Optional
    }

    @Override
    public StudentCourse add(StudentCourse sc) {
        return studentCourseRepository.save(sc);
    }

    @Override
    public StudentCourse update(StudentCourse sc) {
        if (studentCourseRepository.existsById(sc.getId())) {
            return studentCourseRepository.save(sc);
        } else {
            throw new EntityNotFoundException("No se encontró el StudentCourse con ID: " + sc.getId());
        }
    }

    @Override
    public StudentCourse delete(int id) {
        Optional<StudentCourse> optionalStudentCourse = studentCourseRepository.findById(id);
        if (optionalStudentCourse.isPresent()) {
            studentCourseRepository.delete(optionalStudentCourse.get());
            return optionalStudentCourse.get();
        } else {
            return null;  // O lanzar una excepción si es necesario
        }
    }
}
