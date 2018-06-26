package com.capgemini.krk.services.course;

import com.capgemini.krk.TO.course.CourseTO;
import com.capgemini.krk.TO.course.CoursesTO;

public interface CourseService {

    CoursesTO findAll();

    CourseTO findById(int id);

    CoursesTO findByCoursesModuleId(int id);

    void delete(int id);

    void updateCourse(CourseTO course);

    CourseTO insertCourse(int coursesModuleId, CourseTO course);

}
