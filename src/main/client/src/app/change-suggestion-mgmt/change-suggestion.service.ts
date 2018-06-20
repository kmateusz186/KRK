import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map';
import {ChangeSuggestion} from '../model/change-suggestion.model';

@Injectable()
export class ChangeSuggestionService {

    constructor(private http: Http) {
    }

    findAll() {
      return this.http.get('http://localhost:8081/gui/change-suggestions').map(
        (response: Response) => response.json().changeSuggestions
      );
    }

    findByEducationProgramIsNull() {
      return this.http.get('http://localhost:8081/gui/change-suggestions-ef').map(
        (response: Response) => response.json().changeSuggestions
      );
    }

    findByEducationEffectIsNull() {
      return this.http.get('http://localhost:8081/gui/change-suggestions-ep').map(
        (response: Response) => response.json().changeSuggestions
      );
    }

    findChangeSuggestionById(changeSuggestionId: number) {
      return this.http.get('http://localhost:8081/gui/change-suggestions/' + changeSuggestionId)
        .map((response: Response) => response.json());
    }

    findChangeSuggestionEpById(changeSuggestionId: number) {
      return this.http.get('http://localhost:8081/gui/change-suggestions-ep/' + changeSuggestionId)
        .map((response: Response) => response.json());
    }

    findChangeSuggestionEfById(changeSuggestionId: number) {
      return this.http.get('http://localhost:8081/gui/change-suggestions-ef/' + changeSuggestionId)
        .map((response: Response) => response.json());
    }

}
