import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map';
import {EducationProgram} from '../model/education-program.model';

@Injectable()
export class EducationProgramService {

    constructor(private http: Http) {
    }

    findAll() {
      return this.http.get('http://localhost:8081/gui/education-programs')
        .map((response: Response) => {
          console.log(response.json().educationPrograms);
          return response.json().educationPrograms;
        });
    }

    findEducationProgramById(educationProgramId: number) {
      return this.http.get('http://localhost:8081/gui/education-programs/' + educationProgramId)
        .map((response: Response) => response.json());
    }

    updateEducationProgram(educationProgram: EducationProgram) {
      return this.http.put('http://localhost:8081/gui/education-programs-up/', educationProgram);
    }

    insertEducationProgram(educationProgram: EducationProgram) {
      return this.http.put('http://localhost:8081/gui/education-programs-in/', educationProgram);
    }

    deleteEducationProgram(id: number) {
      return this.http.delete('http://localhost:8081/gui/education-programs/' + id);
    }

}
