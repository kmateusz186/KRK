import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router, Params} from '@angular/router';
import {CoursesModuleService} from '../courses-module.service';
import {CoursesModule} from '../../model/studies-plan.model';


@Component({
  selector: 'app-courses-module-ov-details',
  templateUrl: './courses-module-ov-details.component.html',
  styleUrls: ['./courses-module-ov-details.component.scss']
})
export class CoursesModuleOvDetailsComponent implements OnInit {

  selectedCoursesModule: CoursesModule = {
    id: null,
    moduleType: {id: null, name: null},
    ovModule: {id: null, moduleType: {id: null, name: null}, ovModule: null, semesters: [], studiesPlans: []},
    semesters: [],
    studiesPlans: [],
  }

  updateMode: boolean;
  showCoursesModuleChanged: boolean;
  showCoursesModuleAdded: boolean;

  constructor(private coursesModuleService: CoursesModuleService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.updateMode = false;
    this.showCoursesModuleChanged = false;
    this.route.params.subscribe(params => {
      const id = +params['id'];
      if (id!=0) {
        this.updateMode = true;
        this.coursesModuleService.findById(id).subscribe(
          coursesModule => this.selectedCoursesModule = coursesModule
        );
      }
    });
  }

  saveCoursesModule(): void {
    if (this.updateMode) {
      this.coursesModuleService.updateCoursesModule(this.selectedCoursesModule).subscribe(
        success => {
          this.showCoursesModuleChanged = true;
          console.log('ok');
        },
        error => {
          console.log('error' + this.selectedCoursesModule);
        }
      );
    } else {
        this.coursesModuleService.insertCoursesModuleOv(this.selectedCoursesModule).subscribe(
          success => {
            this.showCoursesModuleAdded = true;
            console.log('ok');
          },
          error => {
            console.log('error' + this.selectedCoursesModule);
          }
        );
    }
  }
}
