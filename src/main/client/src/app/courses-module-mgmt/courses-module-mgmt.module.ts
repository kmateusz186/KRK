import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {CoursesModuleDetailsComponent} from './courses-module-details/courses-module-details.component';
import {CoursesModuleOverviewComponent} from './courses-module-overview/courses-module-overview.component';
import {CoursesModuleOvOverviewComponent} from './courses-module-ov-overview/courses-module-ov-overview.component';
import {CoursesModuleOvDetailsComponent} from './courses-module-ov-details/courses-module-ov-details.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
  ],
  declarations: [CoursesModuleDetailsComponent, CoursesModuleOverviewComponent, CoursesModuleOvOverviewComponent, CoursesModuleOvDetailsComponent]
})
export class CoursesModuleMgmtModule { }
