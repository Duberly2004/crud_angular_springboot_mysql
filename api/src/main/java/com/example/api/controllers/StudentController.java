package com.example.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.api.models.Student;
import com.example.api.services.StudentService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public List<Student> getAllStudents() {
        return studentService.list();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getForId(id);
    }

    @PostMapping("")
    public Student createStudent(@RequestBody Student Student) {
        return studentService.add(Student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable("id") int id, @RequestBody Student c) {
        c.setId(id);
        return studentService.update(c);
    }

    @DeleteMapping("/{id}")
    public Student deleteStudent(@PathVariable int id) {
        return studentService.delete(id);
    }
}
