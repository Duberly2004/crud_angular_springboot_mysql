package com.example.api.interfaces;
import java.util.List;
import com.example.api.models.Student;
public interface StudentInterface {   
    List<Student> list();
    Student getForId(int id);
    Student add(Student c);
    Student update(Student c);
    Student delete(int id);
}