import {Routes} from "@angular/router";
import {ChangeSuggestionEpOverviewComponent} from './change-suggestion-mgmt/change-suggestion-ep-overview/change-suggestion-ep-overview.component';
import {ChangeSuggestionEpDetailsComponent} from './change-suggestion-mgmt/change-suggestion-ep-details/change-suggestion-ep-details.component';
import {HomeComponent} from './general/home/home.component';
import {ChangeSuggestionEfOverviewComponent} from './change-suggestion-mgmt/change-suggestion-ef-overview/change-suggestion-ef-overview.component';
import {ChangeSuggestionEfDetailsComponent} from './change-suggestion-mgmt/change-suggestion-ef-details/change-suggestion-ef-details.component';
import {EducationProgramEditDetailsComponent} from './education-program-mgmt/education-program-edit-details/education-program-edit-details.component';
import {EducationProgramEditOverviewComponent} from './education-program-mgmt/education-program-edit-overview/education-program-edit-overview.component';
import {StudiesPlanOverviewComponent} from './studies-plan-mgmt/studies-plan-overview/studies-plan-overview.component';
import {StudiesPlanEditDetailsComponent} from './studies-plan-mgmt/studies-plan-edit-details/studies-plan-edit-details.component';
import {CoursesModuleOverviewComponent} from './courses-module-mgmt/courses-module-overview/courses-module-overview.component';
import {CoursesModuleDetailsComponent} from './courses-module-mgmt/courses-module-details/courses-module-details.component';
import {CoursesModuleOvOverviewComponent} from './courses-module-mgmt/courses-module-ov-overview/courses-module-ov-overview.component';
import {CoursesModuleOvDetailsComponent} from './courses-module-mgmt/courses-module-ov-details/courses-module-ov-details.component';
import {CourseOverviewComponent} from './course-mgmt/course-overview/course-overview.component';
import {CourseDetailsComponent} from './course-mgmt/course-details/course-details.component';
import {EducationProgramOverviewComponent} from './education-program-mgmt/education-program-overview/education-program-overview.component';
import {EducationProgramDetailsComponent} from './education-program-mgmt/education-program-details/education-program-details.component';
import {StudiesPlanEditOverviewComponent} from './studies-plan-mgmt/studies-plan-edit-overview/studies-plan-edit-overview.component';
import {StudiesPlanDetailsComponent} from './studies-plan-mgmt/studies-plan-details/studies-plan-details.component';
import {SubjectCardOverviewComponent} from './subject-card-mgmt/subject-card-overview/subject-card-overview.component';
import {SubjectCardDetailsComponent} from './subject-card-mgmt/subject-card-details/subject-card-details.component';

export const APP_ROUTES: Routes = [
  {
    path: 'app',
    children: [
      {
        path: 'home',
        component: HomeComponent
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
        path: 'education-program-edit',
        children: [
          {
            path: 'overview',
            component: EducationProgramEditOverviewComponent
          },
          {
            path: 'details/:id',
            component: EducationProgramEditDetailsComponent
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
      },
      {
        path: 'studies-plan-edit',
        children: [
          {
            path: 'overview/:id',
            component: StudiesPlanEditOverviewComponent
          },
          {
            path: 'details/:id',
            component: StudiesPlanEditDetailsComponent
          }
        ]
      },
      {
        path: 'courses-module',
        children: [
          {
            path: 'overview/:id',
            component: CoursesModuleOverviewComponent
          },
          {
            path: 'details/:courseId/:semesterId',
            component: CoursesModuleDetailsComponent
          }
        ]
      },
      {
        path: 'courses-module-ov',
        children: [
          {
            path: 'overview/:id',
            component: CoursesModuleOvOverviewComponent
          },
          {
            path: 'details/:courseId/:ovModuleId',
            component: CoursesModuleOvDetailsComponent
          }
        ]
      },
      {
        path: 'course',
        children: [
          {
            path: 'overview/:id',
            component: CourseOverviewComponent
          },
          {
            path: 'details/:courseId/:coursesModuleId',
            component: CourseDetailsComponent
          }
        ]
      },
      {
        path: 'subject-card',
        children: [
          {
            path: 'overview/:id',
            component: SubjectCardOverviewComponent
          },
          {
            path: 'details/:id',
            component: SubjectCardDetailsComponent
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
