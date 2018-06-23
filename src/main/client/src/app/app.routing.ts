import {Routes} from "@angular/router";
import {BookOverviewComponent} from "./book-mgmt/book-overview/book-overview.component";
import {BookDetailsComponent} from "./book-mgmt/book-details/book-details.component";
import {ChangeSuggestionEpOverviewComponent} from './change-suggestion-mgmt/change-suggestion-ep-overview/change-suggestion-ep-overview.component';
import {ChangeSuggestionEpDetailsComponent} from './change-suggestion-mgmt/change-suggestion-ep-details/change-suggestion-ep-details.component';
import {HomeComponent} from './general/home/home.component';
import {ChangeSuggestionEfOverviewComponent} from './change-suggestion-mgmt/change-suggestion-ef-overview/change-suggestion-ef-overview.component';
import {ChangeSuggestionEfDetailsComponent} from './change-suggestion-mgmt/change-suggestion-ef-details/change-suggestion-ef-details.component';
import {EducationProgramDetailsComponent} from './education-program-mgmt/education-program-details/education-program-details.component';
import {EducationProgramOverviewComponent} from './education-program-mgmt/education-program-overview/education-program-overview.component';
import {StudiesPlanOverviewComponent} from './studies-plan-mgmt/studies-plan-overview/studies-plan-overview.component';
import {StudiesPlanDetailsComponent} from './studies-plan-mgmt/studies-plan-details/studies-plan-details.component';

export const APP_ROUTES: Routes = [
  {
    path: 'app',
    children: [
      {
        path: 'home',
        component: HomeComponent
      },
      {
        path: 'book',
        children: [
          {
            path: 'overview',
            component: BookOverviewComponent
          },
          {
            path: 'details/:id',
            component: BookDetailsComponent
          }
        ]
      },
      {
        path: 'change-suggestion-ep',
        children: [
          {
            path: 'overview',
            component: ChangeSuggestionEpOverviewComponent
          },
          {
            path: 'details/:id',
            component: ChangeSuggestionEpDetailsComponent
          }
        ]
      },
      {
        path: 'change-suggestion-ef',
        children: [
          {
            path: 'overview',
            component: ChangeSuggestionEfOverviewComponent
          },
          {
            path: 'details/:id',
            component: ChangeSuggestionEfDetailsComponent
          }
        ]
      },
      {
        path: 'education-program',
        children: [
          {
            path: 'overview',
            component: EducationProgramOverviewComponent
          },
          {
            path: 'details/:id',
            component: EducationProgramDetailsComponent
          }
        ]
      },
      {
        path: 'studies-plan',
        children: [
          {
            path: 'overview/:id',
            component: StudiesPlanOverviewComponent
          },
          {
            path: 'details/:id',
            component: StudiesPlanDetailsComponent
          }
        ]
      }
    ]
  },
  {
    path: '',
    redirectTo: '/app/home',
    pathMatch: 'full'
  }
];
