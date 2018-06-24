import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router, Params} from '@angular/router';
import {CoursesModuleService} from '../courses-module.service';
import {CoursesModule} from '../../model/studies-plan.model';


@Component({
  selector: 'app-courses-module-details',
  templateUrl: './courses-module-details.component.html',
  styleUrls: ['./courses-module-details.component.scss']
})
export class CoursesModuleDetailsComponent implements OnInit {

  private semesterId: number;

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
        this.coursesModuleService.findById(id).subscribe(
          coursesModule => this.selectedCoursesModule = coursesModule
        );
        if(this.selectedCoursesModule.id == null) {
          this.updateMode = false;
          this.semesterId = id;
        } else {
          this.updateMode = true;
        }
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
        this.coursesModuleService.insertCoursesModule(this.semesterId, this.selectedCoursesModule).subscribe(
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
