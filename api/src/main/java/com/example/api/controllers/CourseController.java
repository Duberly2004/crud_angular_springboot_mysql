package com.example.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.api.models.Course;
import com.example.api.services.CourseService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public List<Course> getAllCourses() {
        return courseService.list();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id) {
        return courseService.getForId(id);
    }

    @PostMapping("")
    public Course createCourse(@RequestBody Course Course) {
        return courseService.add(Course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable("id") int id, @RequestBody Course c) {
        c.setId(id);
        return courseService.update(c);
    }

    @DeleteMapping("/{id}")
    public Course deleteCourse(@PathVariable int id) {
        return courseService.delete(id);
    }
}
