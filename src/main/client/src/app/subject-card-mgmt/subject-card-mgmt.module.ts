import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {SubjectCardDetailsComponent} from './subject-card-details/subject-card-details.component';
import {SubjectCardOverviewComponent} from './subject-card-overview/subject-card-overview.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
  ],
  declarations: [SubjectCardDetailsComponent, SubjectCardOverviewComponent]
})
export class SubjectCardMgmtModule { }
