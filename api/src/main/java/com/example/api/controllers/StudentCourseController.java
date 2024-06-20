package com.example.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.api.models.StudentCourse;
import com.example.api.services.StudentCourseService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/studentCourses")
public class StudentCourseController {

    @Autowired
    private StudentCourseService studentCourseService;

    @GetMapping
    public List<StudentCourse> getAllStudentCourses() {
        return studentCourseService.list();
    }

    @GetMapping("/{id}")
    public StudentCourse getStudentCourseById(@PathVariable int id) {
        return studentCourseService.getForId(id);
    }

    @PostMapping
    public StudentCourse createStudentCourse(@RequestBody StudentCourse studentCourse) {
        return studentCourseService.add(studentCourse);
    }

    @PutMapping("/{id}")
    public StudentCourse updateStudentCourse(@PathVariable("id") int id, @RequestBody StudentCourse studentCourse) {
        studentCourse.setId(id);
        return studentCourseService.update(studentCourse);
    }

    @DeleteMapping("/{id}")
    public StudentCourse deleteStudentCourse(@PathVariable int id) {
        return studentCourseService.delete(id);
    }
}
