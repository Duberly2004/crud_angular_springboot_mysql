import { Component } from '@angular/core';
import { Student } from '../../../models/Student';
import { ServiceService } from '../../../services/service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-liststudent',
  templateUrl: './liststudent.component.html',
  styleUrl: './liststudent.component.css'
})
export class ListstudentComponent {
  students: Student[] = [];

  constructor(private service: ServiceService, private router: Router) {}

  ngOnInit(): void {
    this.service.getStudents().subscribe(data => {
      this.students = data;
    });
  }
  createStudent(){
    this.router.navigate(["/students/create"]);
  }
  updateStudent(id: number): void {
    this.router.navigate(['/students/update', id]);
  }

  deleteStudent(student: Student): void {
    this.service.deleteStudent(student.id).subscribe(() => {
      this.students = this.students.filter(c => c !== student);
      alert('Successfully removed');
    });
  }
}
