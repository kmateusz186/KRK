import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map';
import {Course} from '../model/course.model';

@Injectable()
export class CourseService {

    constructor(private http: Http) {
    }

    /*findAll() {
      return this.http.get('http://localhost:8081/gui/studies-plans')
        .map((response: Response) => {
          console.log(response.json().studiesPlans);
          return response.json().studiesPlans;
        });
    } */

    findByCoursesModuleId(coursesModuleId: number) {
      return this.http.get('http://localhost:8081/gui/courses-overview/' + coursesModuleId)
        .map((response: Response) => {
          console.log(response.json().courses);
          return response.json().courses;
        });
    }

    findById(courseId: number) {
      return this.http.get('http://localhost:8081/gui/courses/' + courseId)
        .map((response: Response) => response.json());
    }

    updateCourse(course: Course) {
      return this.http.put('http://localhost:8081/gui/courses-up/', course);
    }

    insertCourse(coursesModuleId: number, course: Course) {
      return this.http.put('http://localhost:8081/gui/courses-in/' + coursesModuleId, course);
    }

    deleteCourse(id: number) {
      return this.http.delete('http://localhost:8081/gui/courses/' + id);
    }

}
