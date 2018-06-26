import {Component, OnInit} from "@angular/core";
import {CourseService} from '../course.service';
import {ActivatedRoute} from '@angular/router';
import {Course} from '../../model/course.model';

@Component({
  selector: 'app-course-overview',
  templateUrl: './course-overview.component.html'
})
export class CourseOverviewComponent implements OnInit {

  currentCourses: Course[];

  constructor(private courseService: CourseService, private route: ActivatedRoute) {
  }

  coursesModuleId: number;

  selectedCourse: Course = {
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

  showCourseDeleted: boolean;
  showCourseAdded: boolean;

  selectAndDeleteCourse(course: Course) {
    this.selectedCourse = course;
    this.deleteCourse();
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const id = +params['id'];
      this.coursesModuleId = id;
        this.courseService.findByCoursesModuleId(id).subscribe(
          courses => this.currentCourses = courses
        );
    });
  }

  deleteCourse(): void {
    this.courseService.deleteCourse(this.selectedCourse.id).subscribe(
      success => {
        this.showCourseDeleted = true;
        console.log('ok');
      },
      error => {
        console.log('error' + this.selectedCourse);
      }
    );
  }

  thereAreCoursesToDisplay(): boolean {
    return this.currentCourses && this.currentCourses.length > 0;
  }

}
