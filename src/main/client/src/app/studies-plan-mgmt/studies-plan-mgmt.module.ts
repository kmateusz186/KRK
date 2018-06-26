import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {StudiesPlanEditDetailsComponent} from './studies-plan-edit-details/studies-plan-edit-details.component';
import {StudiesPlanOverviewComponent} from './studies-plan-overview/studies-plan-overview.component';
import {StudiesPlanEditOverviewComponent} from './studies-plan-edit-overview/studies-plan-edit-overview.component';
import {StudiesPlanDetailsComponent} from './studies-plan-details/studies-plan-details.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
  ],
  declarations: [StudiesPlanEditDetailsComponent, StudiesPlanOverviewComponent, StudiesPlanEditOverviewComponent, StudiesPlanDetailsComponent]
})
export class StudiesPlanMgmtModule { }
