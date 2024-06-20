import { Component } from '@angular/core';
import { Course } from '../../../models/Course';
import { ActivatedRoute, Router } from '@angular/router';
import { ServiceService } from '../../../services/service.service';

@Component({
  selector: 'app-updatecourse',
  templateUrl: './updatecourse.component.html',
  styleUrl: './updatecourse.component.css'
})
export class UpdatecourseComponent {
  course: Course = new Course();

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private service: ServiceService
  ) {}

  ngOnInit() {
    this.updateCourse();
  }

  updateCourse() {
    const id = this.route.snapshot.params['id'];
    if (id) {
      this.service.getCourseId(id).subscribe((data: Course) => {
        this.course = data;
      }, (error) => {
        console.error('Error al obtener la course:', error);
        this.router.navigate(['/']);
      });
    } else {
      this.router.navigate(['/']); 
    }
  }

  editCourse() {
    this.service.updateCourse(this.course).subscribe((data: Course) => {
      this.course = data;
      alert('La course se actualizó exitosamente');
      this.router.navigate(['/courses']); 
    }, (error) => {
      console.error('Error al edit la course:', error);
    });
  }
}
