import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class SubjectCardService {

    constructor(private http: Http) {
    }

    /*findAll() {
      return this.http.get('http://localhost:8081/gui/studies-plans')
        .map((response: Response) => {
          console.log(response.json().studiesPlans);
          return response.json().studiesPlans;
        });
    } */

    findByCourseId(courseId: number) {
      return this.http.get('http://localhost:8081/gui/subject-cards-overview/' + courseId)
        .map((response: Response) => {
          console.log(response.json().subjectCards);
          return response.json().subjectCards;
        });
    }

    findById(subjectCardId: number) {
      return this.http.get('http://localhost:8081/gui/subject-cards/' + subjectCardId)
        .map((response: Response) => {
          console.log(response.json());
          return response.json();
        });
    }

}
