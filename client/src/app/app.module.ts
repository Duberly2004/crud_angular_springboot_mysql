import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreatestudentComponent } from './components/student/createstudent/createstudent.component';
import { UpdatestudentComponent } from './components/student/updatestudent/updatestudent.component';
import { ListstudentComponent } from './components/student/liststudent/liststudent.component';
import { ListcourseComponent } from './components/course/listcourse/listcourse.component';
import { UpdatecourseComponent } from './components/course/updatecourse/updatecourse.component';
import { CreatecourseComponent } from './components/course/createcourse/createcourse.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ServiceService } from './services/service.service';

@NgModule({
  declarations: [
    AppComponent,
    CreatestudentComponent,
    UpdatestudentComponent,
    ListstudentComponent,
    ListcourseComponent,
    UpdatecourseComponent,
    CreatecourseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    ServiceService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
