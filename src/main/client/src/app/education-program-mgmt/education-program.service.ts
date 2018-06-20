import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class EducationProgramService {

    constructor(private http: Http) {
    }

    findAll() {
      return this.http.get('http://localhost:8081/gui/education-programs').map(
        (response: Response) => response.json().educationPrograms
      );
    }

    findEducationProgramById(educationProgramId: number) {
      return this.http.get('http://localhost:8081/gui/education-programs/' + educationProgramId)
        .map((response: Response) => response.json());
    }

}
