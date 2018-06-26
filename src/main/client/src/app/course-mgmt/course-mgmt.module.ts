import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {CourseDetailsComponent} from './course-details/course-details.component';
import {CourseOverviewComponent} from './course-overview/course-overview.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
  ],
  declarations: [CourseDetailsComponent, CourseOverviewComponent]
})
export class CourseMgmtModule { }
