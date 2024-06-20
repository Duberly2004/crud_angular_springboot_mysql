import { Component } from '@angular/core';
import { Student } from '../../../models/Student';
import { ActivatedRoute, Router } from '@angular/router';
import { ServiceService } from '../../../services/service.service';

@Component({
  selector: 'app-updatestudent',
  templateUrl: './updatestudent.component.html',
  styleUrl: './updatestudent.component.css'
})
export class UpdatestudentComponent {
  student: Student = new Student();

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private service: ServiceService
  ) {}

  ngOnInit() {
    this.updateStudent();
  }

  updateStudent() {
    const id = this.route.snapshot.params['id'];
    if (id) {
      this.service.getStudentId(id).subscribe((data: Student) => {
        this.student = data;
      }, (error) => {
        console.error('Error:', error);
        this.router.navigate(['/']);
      });
    } else {
      this.router.navigate(['/']); 
    }
  }

  editStudent() {
    this.service.updateStudent(this.student).subscribe((data: Student) => {
      this.student = data;
      alert('Saved successfully');
      this.router.navigate(['/students']); 
    }, (error) => {
      console.error('Error', error);
    });
  }
}
