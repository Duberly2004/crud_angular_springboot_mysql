import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from '../models/Student';
import { Course } from '../models/Course';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  private Url = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) { }

  getStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(`${this.Url}/students`);
  }

  createStudent(Student: Student): Observable<Student> {
    return this.http.post<Student>(`${this.Url}/students`, Student);
  }

  getStudentId(id: number): Observable<Student> {
    return this.http.get<Student>(`${this.Url}/students/${id}`);
  }

  updateStudent(Student: Student): Observable<Student> {
    return this.http.put<Student>(`${this.Url}/students/${Student.id}`, Student);
  }

  deleteStudent(id: number): Observable<void> {
    return this.http.delete<void>(`${this.Url}/students/${id}`);
  }

  getCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(`${this.Url}/courses`);
  }
  
  createCourse(Course: Course): Observable<Course> {
    return this.http.post<Course>(`${this.Url}/courses`, Course);
  }
  
  getCourseId(id: number): Observable<Course> {
    return this.http.get<Course>(`${this.Url}/courses/${id}`);
  }
  
  updateCourse(Course: Course): Observable<Course> {
    return this.http.put<Course>(`${this.Url}/courses/${Course.id}`, Course);
  }
  
  deleteCourse(id: number): Observable<void> { 
    return this.http.delete<void>(`${this.Url}/courses/${id}`);
  }  
}
