import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router, Params} from '@angular/router';
import {ChangeSuggestion} from '../../model/change-suggestion.model';
import {ChangeSuggestionService} from '../change-suggestion.service';


@Component({
  selector: 'app-change-suggestion-ep-details',
  templateUrl: './change-suggestion-ep-details.component.html',
  styleUrls: ['./change-suggestion-ep-details.component.scss']
})
export class ChangeSuggestionEpDetailsComponent implements OnInit {
  changeSuggestion: ChangeSuggestion = {
    id: null,
    evaluator: null,
    educationProgram: {id: null, level: null, profile: null, course: null, specialization: null, mode: null, period: null, faculty: null, changeSuggestions: null, courseEducationEffects: null},
    proposition: null,
    reason: null,
  };

  showNameChanged: boolean;

  constructor(private changeSuggestionService: ChangeSuggestionService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.showNameChanged = false;
    this.route.params.subscribe(params => {
      const id = +params['id'];

      this.changeSuggestionService.findChangeSuggestionById(id).subscribe(
        changeSuggestion => this.changeSuggestion = changeSuggestion
      );
    });
  }
}
