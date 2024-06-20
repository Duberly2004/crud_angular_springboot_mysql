import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListstudentComponent } from './components/student/liststudent/liststudent.component';
import { CreatestudentComponent } from './components/student/createstudent/createstudent.component';
import { UpdatestudentComponent } from './components/student/updatestudent/updatestudent.component';
import { ListcourseComponent } from './components/course/listcourse/listcourse.component';
import { CreatecourseComponent } from './components/course/createcourse/createcourse.component';
import { UpdatecourseComponent } from './components/course/updatecourse/updatecourse.component';

const routes: Routes = [
  {path:'students',component:ListstudentComponent},
  {path:'students/create',component:CreatestudentComponent},
  {path:'students/update/:id',component:UpdatestudentComponent},
  {path:'courses',component:ListcourseComponent},
  {path:'courses/create',component:CreatecourseComponent},
  {path:'courses/update/:id',component:UpdatecourseComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
