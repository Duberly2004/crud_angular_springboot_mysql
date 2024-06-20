import { Component } from '@angular/core';
import { Course } from '../../../models/Course';
import { ServiceService } from '../../../services/service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listcourse',
  templateUrl: './listcourse.component.html',
  styleUrl: './listcourse.component.css'
})
export class ListcourseComponent {
  courses: Course[] = [];

  constructor(private service: ServiceService, private router: Router) {}

  ngOnInit(): void {
    this.service.getCourses().subscribe(data => {
      this.courses = data;
    });
  }
  createCourse(){
    this.router.navigate(["/courses/create"]);
  }
  updateCourse(id: number): void {
    this.router.navigate(['/courses/update', id]);
  }

  deleteCourse(course: Course): void {
    this.service.deleteCourse(course.id).subscribe(() => {
      this.courses = this.courses.filter(c => c !== course);
      alert('Successfully removed');
    });
  }
}
