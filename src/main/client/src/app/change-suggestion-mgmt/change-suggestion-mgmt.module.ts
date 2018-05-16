import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ChangeSuggestionDetailsComponent} from './change-suggestion-details/change-suggestion-details.component';
import {ChangeSuggestionOverviewComponent} from './change-suggestion-overview/change-suggestion-overview.component';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
  ],
  declarations: [ChangeSuggestionDetailsComponent, ChangeSuggestionOverviewComponent]
})
export class ChangeSuggestionMgmtModule {
}
