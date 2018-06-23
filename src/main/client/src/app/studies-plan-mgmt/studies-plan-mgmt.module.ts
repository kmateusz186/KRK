import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {StudiesPlanDetailsComponent} from './studies-plan-details/studies-plan-details.component';
import {StudiesPlanOverviewComponent} from './studies-plan-overview/studies-plan-overview.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
  ],
  declarations: [StudiesPlanDetailsComponent, StudiesPlanOverviewComponent]
})
export class StudiesPlanMgmtModule { }
