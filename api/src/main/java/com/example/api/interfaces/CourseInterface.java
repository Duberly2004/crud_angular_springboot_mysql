package com.example.api.interfaces;
import java.util.List;
import com.example.api.models.Course;
public interface CourseInterface {   
    List<Course> list();
    Course getForId(int id);
    Course add(Course c);
    Course update(Course c);
    Course delete(int id);
}