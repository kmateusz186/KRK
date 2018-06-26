import {Component, OnInit} from "@angular/core";
import {StudiesPlanService} from '../studies-plan.service';
import {StudiesPlan} from '../../model/studies-plan.model';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-studies-plan-edit-overview',
  templateUrl: './studies-plan-edit-overview.component.html'
})
export class StudiesPlanEditOverviewComponent implements OnInit {

  currentStudiesPlans: StudiesPlan[];

  constructor(private studiesPlanService: StudiesPlanService, private route: ActivatedRoute) {
  }

  educationProgramId: number;

  selectedStudiesPlan: StudiesPlan = {
    id: null,
    semesters: [],
    educationProgram: {id: null, level: null, profile: null, course: null, specialization: null, mode: null, period: null, faculty: null, changeSuggestions: null, courseEducationEffects: null}
  };

  showStudiesPlanDeleted: boolean;
  showStudiesPlanAdded: boolean;

  selectAndDeleteStudiesPlan(studiesPlan: StudiesPlan) {
    this.selectedStudiesPlan = studiesPlan;
    this.deleteStudiesPlan();
  }

  ngOnInit(): void {
    /*this.studiesPlanService.findAll().subscribe(
      (studiesPlans) => {
        this.currentStudiesPlans = studiesPlans;
      }
    );*/
    this.route.params.subscribe(params => {
      const id = +params['id'];
      this.educationProgramId = id;
        this.studiesPlanService.findByEducationProgramId(id).subscribe(
          studiesPlans => this.currentStudiesPlans = studiesPlans
        );
    });
  }

  deleteStudiesPlan(): void {
    this.studiesPlanService.deleteStudiesPlan(this.selectedStudiesPlan.id).subscribe(
      success => {
        this.showStudiesPlanDeleted = true;
        console.log('ok');
      },
      error => {
        console.log('error' + this.selectedStudiesPlan);
      }
    );
  }

  saveStudiesPlan(): void {
    this.selectedStudiesPlan.educationProgram.id = this.educationProgramId;
    this.studiesPlanService.insertStudiesPlan(this.selectedStudiesPlan).subscribe(
      success => {
        this.showStudiesPlanAdded = true;
        console.log('ok');
      },
      error => {
        console.log('error' + this.selectedStudiesPlan);
      }
    );
  }

  thereAreStudiesPlansToDisplay(): boolean {
    return this.currentStudiesPlans && this.currentStudiesPlans.length > 0;
  }

}
