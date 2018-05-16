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

    findChangeSuggestionById(changeSuggestionId: number) {
      return this.http.get('http://localhost:8081/gui/change-suggestions/' + changeSuggestionId)
        .map((response: Response) => response.json());
    }

    saveControlPointName(changeSuggestion: ChangeSuggestion) {
      return this.http.put('http://localhost:8081/gui/change-suggestions', changeSuggestion);
    }

    deleteControlPoint(changeSuggestionId: number) {
      return this.http.delete('http://localhost:8081/gui/control-points/' + changeSuggestionId);
    }

}
