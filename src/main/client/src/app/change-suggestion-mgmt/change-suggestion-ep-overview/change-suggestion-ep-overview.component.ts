import {Component, OnInit} from "@angular/core";
import {ChangeSuggestionService} from "../change-suggestion.service";
import {ChangeSuggestion} from '../../model/change-suggestion.model';

@Component({
  selector: 'app-change-suggestion-ep-overview',
  templateUrl: './change-suggestion-ep-overview.component.html'
})
export class ChangeSuggestionEpOverviewComponent implements OnInit {

  currentChangeSuggestions: ChangeSuggestion[];

  constructor(private changeSuggestionService: ChangeSuggestionService) {
  }

  selectedChangeSuggestion: ChangeSuggestion = {
    id: null,
    evaluator: null,
    educationProgram: {id: null, level: null, profile: null, course: null, specialization: null, mode: null, period: null, faculty: null, changeSuggestions: null, courseEducationEffects: null},
    proposition: null,
    reason: null,
  };

  selectChangeSuggestion(changeSuggestion: ChangeSuggestion) {
    this.selectedChangeSuggestion = changeSuggestion;
  }

  ngOnInit(): void {
    this.changeSuggestionService.findAll().subscribe(
      (changeSuggestions) => {
        this.currentChangeSuggestions = changeSuggestions;
      }
    );
  }

  thereAreChangeSuggestionsToDisplay(): boolean {
    return this.currentChangeSuggestions && this.currentChangeSuggestions.length > 0;
  }

}
