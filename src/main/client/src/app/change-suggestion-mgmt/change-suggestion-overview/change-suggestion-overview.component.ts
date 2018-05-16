import {Component, OnInit} from "@angular/core";
import {ChangeSuggestionService} from "../change-suggestion.service";
import {ChangeSuggestion} from '../../model/change-suggestion.model';

@Component({
  selector: 'app-change-suggestion-overview',
  templateUrl: './change-suggestion-overview.component.html'
})
export class ChangeSuggestionOverviewComponent implements OnInit {

  currentChangeSuggestions: ChangeSuggestion[];

  constructor(private changeSuggestionService: ChangeSuggestionService) {
  }

  selectedChangeSuggestion: ChangeSuggestion = {
    id: null,
    evaluator: null,
    educationProgram: {id: null, level: null, profile: null, course: null, specialization: null, mode: null, period: null, faculty: null, changeSuggestions: null},
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
