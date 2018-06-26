import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router, Params} from '@angular/router';
import {CourseService} from '../course.service';
import {Course} from '../../model/course.model';


@Component({
  selector: 'app-course-details',
  templateUrl: './course-details.component.html',
  styleUrls: ['./course-details.component.scss']
})
export class CourseDetailsComponent implements OnInit {

  private coursesModuleId: number;

  course: Course = {
    id: null,
    name: null,
    ects: null,
    technical: null,
    code: null,
    zzuHours: null,
    classesType: {id: null, name: null},
    courseType: {id: null, name: null},
    coursesGroup: {id: null, name: null, courses: []},
    courseForm: {id: null, name: null},
    kind: {id: null, name: null},
    passingWay: {id: null, name: null},
    subject: {id: null, namePL: null, nameEng: null, code: null, prerequisites: null, courseEducationEffects: [], subjectCards: []},
  };

  saveTechnical: boolean;
  updateMode: boolean;
  showCoursesChanged: boolean;
  showCoursesAdded: boolean;

  constructor(private courseService: CourseService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.updateMode = false;
    this.showCoursesChanged = false;
    this.route.params.subscribe(params => {
      const courseId = +params['courseId'];
      const coursesModuleId =+params['coursesModuleId'];
      if (courseId!=0) {
        this.updateMode = true;
        this.courseService.findById(courseId).subscribe(
          course => this.course = course
        );
      } else {
        this.updateMode = false;
        this.coursesModuleId = coursesModuleId;
      }
    });
  }

  saveCourse(): void {
    this.course.technical = this.saveTechnical;
    if (this.updateMode) {
      this.courseService.updateCourse(this.course).subscribe(
        success => {
          this.showCoursesChanged = true;
          console.log('ok');
        },
        error => {
          console.log('error' + this.course);
        }
      );
    } else {
      this.courseService.insertCourse(this.coursesModuleId, this.course).subscribe(
        success => {
          this.showCoursesAdded = true;
          console.log('ok');
        },
        error => {
          console.log('error' + this.course);
        }
      );
    }
  }

  public onSaveTechnicalChanged(value: boolean){
    this.saveTechnical = value;
  }
}
