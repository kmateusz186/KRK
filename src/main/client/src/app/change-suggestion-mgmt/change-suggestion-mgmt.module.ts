import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ChangeSuggestionEpDetailsComponent} from './change-suggestion-ep-details/change-suggestion-ep-details.component';
import {ChangeSuggestionEpOverviewComponent} from './change-suggestion-ep-overview/change-suggestion-ep-overview.component';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {ChangeSuggestionEfDetailsComponent} from './change-suggestion-ef-details/change-suggestion-ef-details.component';
import {ChangeSuggestionEfOverviewComponent} from './change-suggestion-ef-overview/change-suggestion-ef-overview.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
  ],
  declarations: [ChangeSuggestionEpDetailsComponent, ChangeSuggestionEpOverviewComponent, ChangeSuggestionEfDetailsComponent, ChangeSuggestionEfOverviewComponent]
})
export class ChangeSuggestionMgmtModule {
}
