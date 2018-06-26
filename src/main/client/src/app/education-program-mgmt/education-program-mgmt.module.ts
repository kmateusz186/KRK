import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {EducationProgramEditDetailsComponent} from './education-program-edit-details/education-program-edit-details.component';
import {EducationProgramEditOverviewComponent} from './education-program-edit-overview/education-program-edit-overview.component';
import {EducationProgramDetailsComponent} from './education-program-details/education-program-details.component';
import {EducationProgramOverviewComponent} from './education-program-overview/education-program-overview.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
  ],
  declarations: [EducationProgramEditDetailsComponent, EducationProgramEditOverviewComponent, EducationProgramDetailsComponent, EducationProgramOverviewComponent]
})
export class EducationProgramMgmtModule { }
