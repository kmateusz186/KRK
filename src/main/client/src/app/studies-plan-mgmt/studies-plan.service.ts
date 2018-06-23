import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map';
import {StudiesPlan} from '../model/studies-plan.model';

@Injectable()
export class StudiesPlanService {

    constructor(private http: Http) {
    }

    /*findAll() {
      return this.http.get('http://localhost:8081/gui/studies-plans')
        .map((response: Response) => {
          console.log(response.json().studiesPlans);
          return response.json().studiesPlans;
        });
    } */

    findByEducationProgramId(educationProgramId: number) {
      return this.http.get('http://localhost:8081/gui/studies-plans-overview/' + educationProgramId)
        .map((response: Response) => {
          console.log(response.json().studiesPlans);
          return response.json().studiesPlans;
        });
    }

    findById(educationProgramId: number) {
      return this.http.get('http://localhost:8081/gui/studies-plans/' + educationProgramId)
        .map((response: Response) => response.json());
    }

    updateStudiesPlan(studiesPlan: StudiesPlan) {
      return this.http.put('http://localhost:8081/gui/studies-plans-up/', studiesPlan);
    }

    insertStudiesPlan(studiesPlan: StudiesPlan) {
      return this.http.put('http://localhost:8081/gui/studies-plans-in/', studiesPlan);
    }

    insertSemester(studiesPlan: StudiesPlan) {
      return this.http.put('http://localhost:8081/gui/studies-plans-semester/', studiesPlan);
    }

    deleteStudiesPlan(id: number) {
      return this.http.delete('http://localhost:8081/gui/studies-plans/' + id);
    }

    deleteSemester(id: number) {
      return this.http.delete('http://localhost:8081/gui/studies-plans-semester/' + id);
    }

}
