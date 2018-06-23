import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router, Params} from '@angular/router';
import {StudiesPlanService} from '../studies-plan.service';
import {Semester, StudiesPlan} from '../../model/studies-plan.model';


@Component({
  selector: 'app-studies-plan-details',
  templateUrl: './studies-plan-details.component.html',
  styleUrls: ['./studies-plan-details.component.scss']
})
export class StudiesPlanDetailsComponent implements OnInit {

  selectedSemester: Semester = {
    id: null,
    number: null,
    studiesPlan: null,
    coursesModules: []
  }

  studiesPlan: StudiesPlan = {
    id: null,
    semesters: [],
    educationProgram: {id: null, level: {id: null, name: null}, profile: {id: null, name: null}, course: null, specialization: null, mode: {id: null, name: null}, period: null, faculty: {id: null, name: null}, changeSuggestions: null, courseEducationEffects: null}
  };

  updateMode: boolean;
  showStudiesPlanChanged: boolean;
  showStudiesPlanAdded: boolean;

  constructor(private studiesPlanService: StudiesPlanService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.updateMode = false;
    this.showStudiesPlanChanged = false;
    this.route.params.subscribe(params => {
      const id = +params['id'];
      if (id!=0) {
        this.updateMode = true;
        this.studiesPlanService.findById(id).subscribe(
          studiesPlan => this.studiesPlan = studiesPlan
        );
      }
    });
  }

  saveStudiesPlan(): void {
    if (this.updateMode) {
      this.studiesPlanService.updateStudiesPlan(this.studiesPlan).subscribe(
        success => {
          this.showStudiesPlanChanged = true;
          console.log('ok');
        },
        error => {
          console.log('error' + this.studiesPlan);
        }
      );
    } else {
      this.studiesPlanService.insertStudiesPlan(this.studiesPlan).subscribe(
        success => {
          this.showStudiesPlanAdded = true;
          console.log('ok');
        },
        error => {
          console.log('error' + this.studiesPlan);
        }
      );
    }
  }
}
