import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {AppComponent} from './app.component';
import {GeneralModule} from './general/general.module';
import {RouterModule} from '@angular/router';
import {APP_ROUTES} from './app.routing';
import {ChangeSuggestionMgmtModule} from './change-suggestion-mgmt/change-suggestion-mgmt.module';
import {ChangeSuggestionService} from './change-suggestion-mgmt/change-suggestion.service';
import {EducationProgramMgmtModule} from './education-program-mgmt/education-program-mgmt.module';
import {EducationProgramService} from './education-program-mgmt/education-program.service';
import {StudiesPlanMgmtModule} from './studies-plan-mgmt/studies-plan-mgmt.module';
import {StudiesPlanService} from './studies-plan-mgmt/studies-plan.service';
import {CoursesModuleMgmtModule} from './courses-module-mgmt/courses-module-mgmt.module';
import {CoursesModuleService} from './courses-module-mgmt/courses-module.service';
import {CourseMgmtModule} from './course-mgmt/course-mgmt.module';
import {CourseService} from './course-mgmt/course.service';
import {SubjectCardService} from './subject-card-mgmt/subject-card.service';
import {SubjectCardMgmtModule} from './subject-card-mgmt/subject-card-mgmt.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(APP_ROUTES),
    GeneralModule,
    ChangeSuggestionMgmtModule,
    EducationProgramMgmtModule,
    StudiesPlanMgmtModule,
    CoursesModuleMgmtModule,
    CourseMgmtModule,
    SubjectCardMgmtModule
  ],
  providers: [ChangeSuggestionService, EducationProgramService, StudiesPlanService, CoursesModuleService, CourseService, SubjectCardService],
  bootstrap: [AppComponent]
})
export class AppModule {

}
