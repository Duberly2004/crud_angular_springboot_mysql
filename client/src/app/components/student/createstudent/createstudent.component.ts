import { Component } from '@angular/core';
import { Student } from '../../../models/Student';
import { Router } from '@angular/router';
import { ServiceService } from '../../../services/service.service';

@Component({
  selector: 'app-createstudent',
  templateUrl: './createstudent.component.html',
  styleUrl: './createstudent.component.css'
})
export class CreatestudentComponent {
  student: Student = new Student();
  constructor(private router: Router, private service: ServiceService) {}

  ngOnInit() {
  }

  createStudent() {
    this.service.createStudent(this.student)
      .subscribe(data => {
        alert("Saved successfully");
        this.router.navigate(["students"]);
      });
  }
}
