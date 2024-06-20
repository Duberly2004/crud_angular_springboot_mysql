package com.example.api.interfaces;
import java.util.List;
import com.example.api.models.StudentCourse;

public interface StudentCourseInterface {
    List<StudentCourse> list();
    StudentCourse getForId(int id);
    StudentCourse add(StudentCourse sc);
    StudentCourse update(StudentCourse sc);
    StudentCourse delete(int id);
}
