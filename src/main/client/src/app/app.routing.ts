import {Routes} from "@angular/router";
import {BookOverviewComponent} from "./book-mgmt/book-overview/book-overview.component";
import {BookDetailsComponent} from "./book-mgmt/book-details/book-details.component";
import {ChangeSuggestionOverviewComponent} from './change-suggestion-mgmt/change-suggestion-overview/change-suggestion-overview.component';
import {ChangeSuggestionDetailsComponent} from './change-suggestion-mgmt/change-suggestion-details/change-suggestion-details.component';
import {HomeComponent} from './general/home/home.component';

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
        path: 'change-suggestion',
        children: [
          {
            path: 'overview',
            component: ChangeSuggestionOverviewComponent
          },
          {
            path: 'details/:id',
            component: ChangeSuggestionDetailsComponent
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
