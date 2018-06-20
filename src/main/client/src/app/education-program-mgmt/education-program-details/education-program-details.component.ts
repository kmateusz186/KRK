import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router, Params} from '@angular/router';
import {ChangeSuggestion} from '../../model/change-suggestion.model';
import {EducationProgramService} from '../education-program.service';


@Component({
  selector: 'app-education-program-details',
  templateUrl: './education-program-details.component.html',
  styleUrls: ['./education-program-details.component.scss']
})
export class EducationProgramDetailsComponent implements OnInit {
  changeSuggestion: ChangeSuggestion = {
    id: null,
    evaluator: null,
    educationProgram: {id: null, level: null, profile: null, course: null, specialization: null, mode: null, period: null, faculty: null, changeSuggestions: null, courseEducationEffects: null},
    proposition: null,
    reason: null,
  };

  showNameChanged: boolean;

  constructor(private educationProgramService: EducationProgramService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.showNameChanged = false;
    this.route.params.subscribe(params => {
      const id = +params['id'];

      this.educationProgramService.findEducationProgramById(id).subscribe(
        changeSuggestion => this.changeSuggestion = changeSuggestion
      );
    });
  }
}
