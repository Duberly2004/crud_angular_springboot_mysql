package com.example.api.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.api.interfaces.StudentInterface;
import com.example.api.models.Student;
import com.example.api.repositories.StudentRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentService implements StudentInterface {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> list() {
        return studentRepository.findAll();
    }

    @Override
    public Student getForId(int id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElse(null);  // Manejo correcto de Optional
    }

    @Override
    public Student add(Student c) {
        return studentRepository.save(c);
    }

    @Override
    public Student update(Student c) {
        if (studentRepository.existsById(c.getId())) {
            return studentRepository.save(c);
        } else {
            throw new EntityNotFoundException("No se encontró la Student con ID: " + c.getId());
        }
    }

    @Override
    public Student delete(int id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            studentRepository.delete(optionalStudent.get());
            return optionalStudent.get();
        } else {
            return null;  // O lanzar una excepción si es necesario
        }
    }
}
