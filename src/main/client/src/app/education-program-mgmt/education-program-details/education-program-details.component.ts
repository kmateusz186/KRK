import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router, Params} from '@angular/router';
import {EducationProgramService} from '../education-program.service';
import {EducationProgram, Mode} from '../../model/education-program.model';
import {EducationLevel, Faculty} from '../../model/change-suggestion.model';


@Component({
  selector: 'app-education-program-details',
  templateUrl: './education-program-details.component.html',
  styleUrls: ['./education-program-details.component.scss']
})
export class EducationProgramDetailsComponent implements OnInit {

  levels: EducationLevel[];
  modes: Mode[];
  faculties: Faculty[];

  educationProgram: EducationProgram = {
    id: null,
    level: {id: null, name: null},
    profile: {id: null, name: null},
    course: null,
    specialization: null,
    mode: {id: null, name: null},
    period: null,
    faculty: {id: null, name: null},
    changeSuggestions: null,
    courseEducationEffects: null,
  };
  updateMode: boolean;
  showEducationProgramChanged: boolean;
  showEducationProgramAdded: boolean;

  constructor(private educationProgramService: EducationProgramService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.updateMode = false;
    this.showEducationProgramChanged = false;
    this.route.params.subscribe(params => {
      const id = +params['id'];

      if (id!=0) {
        this.updateMode = true;
        this.educationProgramService.findEducationProgramById(id).subscribe(
          educationProgram => this.educationProgram = educationProgram
        );
      }
    });
  }

  saveEducationProgram(): void {
    if (this.updateMode) {
      this.educationProgramService.updateEducationProgram(this.educationProgram).subscribe(
        success => {
          this.showEducationProgramChanged = true;
          console.log('ok');
        },
        error => {
          console.log('error' + this.educationProgram);
        }
      );
    } else {
      this.educationProgramService.insertEducationProgram(this.educationProgram).subscribe(
        success => {
          this.showEducationProgramAdded = true;
          console.log('ok');
        },
        error => {
          console.log('error' + this.educationProgram);
        }
      );
    }

  }
}
