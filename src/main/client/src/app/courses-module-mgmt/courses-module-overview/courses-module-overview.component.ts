import {Component, OnInit} from "@angular/core";
import {CoursesModuleService} from '../courses-module.service';
import {CoursesModule, StudiesPlan} from '../../model/studies-plan.model';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-courses-module-overview',
  templateUrl: './courses-module-overview.component.html'
})
export class CoursesModuleOverviewComponent implements OnInit {

  currentCoursesModules: CoursesModule[];

  constructor(private coursesModuleService: CoursesModuleService, private route: ActivatedRoute, private router: Router) {
  }

  semesterId: number;

  selectedCoursesModule: CoursesModule = {
    id: null,
    moduleType: {id: null, name: null},
    ovModule: {id: null, moduleType: {id: null, name: null}, ovModule: null, courses: [], semesters: [], ovModules: [], studiesPlans: []},
    courses: [],
    semesters: [],
    ovModules: [],
    studiesPlans: [],
  };

  showCoursesModuleDeleted: boolean;
  showCoursesModuleAdded: boolean;
  showCoursesModuleOv: boolean;

  goToCoursesModulesOv(coursesModule: CoursesModule) {
    this.router.navigate(['/app/courses-module-ov/overview', coursesModule.id]);
  }

  selectAndDeleteCoursesModule(coursesModule: CoursesModule) {
    this.selectedCoursesModule = coursesModule;
    this.deleteCoursesModule();
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const id = +params['id'];
      this.semesterId = id;
        this.coursesModuleService.findBySemesterId(id).subscribe(
          coursesModules => this.currentCoursesModules = coursesModules
        );
    });
  }

  deleteCoursesModule(): void {
    this.coursesModuleService.deleteCoursesModule(this.selectedCoursesModule.id).subscribe(
      success => {
        this.showCoursesModuleDeleted = true;
        console.log('ok');
      },
      error => {
        console.log('error' + this.selectedCoursesModule);
      }
    );
  }

  thereAreCoursesModulesToDisplay(): boolean {
    return this.currentCoursesModules && this.currentCoursesModules.length > 0;
  }

}
