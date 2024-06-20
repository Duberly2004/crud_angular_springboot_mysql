import { Component } from '@angular/core';
import { Course } from '../../../models/Course';
import { Router } from '@angular/router';
import { ServiceService } from '../../../services/service.service';

@Component({
  selector: 'app-createcourse',
  templateUrl: './createcourse.component.html',
  styleUrl: './createcourse.component.css'
})
export class CreatecourseComponent {
  course: Course = new Course();

  constructor(private router: Router, private service: ServiceService) {}

  ngOnInit() {
  }

  createCourse() {
    this.service.createCourse(this.course)
      .subscribe(data => {
        alert("Save successfull");
        this.router.navigate(["courses"]);
      });
  }
}
