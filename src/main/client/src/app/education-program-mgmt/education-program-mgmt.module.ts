import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {EducationProgramDetailsComponent} from './education-program-details/education-program-details.component';
import {EducationProgramOverviewComponent} from './education-program-overview/education-program-overview.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
  ],
  declarations: [EducationProgramDetailsComponent, EducationProgramOverviewComponent]
})
export class EducationProgramMgmtModule { }
