import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map';
import {CoursesModule, StudiesPlan} from '../model/studies-plan.model';

@Injectable()
export class CoursesModuleService {

    constructor(private http: Http) {
    }

    findBySemesterId(semesterId: number) {
      return this.http.get('http://localhost:8081/gui/courses-modules-overview/' + semesterId)
        .map((response: Response) => {
          console.log(response.json().coursesModules);
          return response.json().coursesModules;
        });
    }

    findByOvModuleId(ovModuleId: number) {
      return this.http.get('http://localhost:8081/gui/courses-modules-ov-overview/' + ovModuleId)
        .map((response: Response) => {
          console.log(response.json().coursesModules);
          return response.json().coursesModules;
        });
    }

    findById(coursesModuleId: number) {
      return this.http.get('http://localhost:8081/gui/courses-modules/' + coursesModuleId)
        .map((response: Response) => response.json());
    }

    updateCoursesModule(coursesModule: CoursesModule) {
      return this.http.put('http://localhost:8081/gui/courses-modules-up/', coursesModule);
    }

    insertCoursesModuleOv(coursesModule: CoursesModule) {
      return this.http.put('http://localhost:8081/gui/courses-modules-in-ov/', coursesModule);
    }

    insertCoursesModule(semesterId: number, coursesModule: CoursesModule) {
      return this.http.put('http://localhost:8081/gui/courses-modules-in/' + semesterId, coursesModule);
    }

    deleteCoursesModule(id: number) {
      return this.http.delete('http://localhost:8081/gui/courses-modules/' + id);
    }

}
