package com.capgemini.krk.rest.course;

import com.capgemini.krk.TO.course.CourseTO;
import com.capgemini.krk.TO.course.CoursesTO;
import com.capgemini.krk.services.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/gui")
public class CourseRestServiceGUI {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/courses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CoursesTO findAll() {
        CoursesTO coursesTO =  courseService.findAll();
        return coursesTO;
    }

    @RequestMapping(value = "/courses-overview/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CoursesTO findByCoursesModuleId(@PathVariable int id) {
        CoursesTO coursesTO =  courseService.findByCoursesModuleId(id);
        return coursesTO;
    }

    @RequestMapping(value = "courses/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CourseTO findById(@PathVariable int id) {
        CourseTO courseTO = courseService.findById(id);
        return courseTO;
    }

    @RequestMapping(value = "/courses/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        courseService.delete(id);
    }


    @RequestMapping(value = "/courses-up", method = RequestMethod.PUT)
    public void update(@RequestBody CourseTO courseTO) {
        courseService.updateCourse(courseTO);
    }

    @RequestMapping(value = "/courses-in/{coursesModuleId}", method = RequestMethod.PUT)
    public void insert(@PathVariable int coursesModuleId, @RequestBody CourseTO courseTO) {
        courseService.insertCourse(coursesModuleId, courseTO);
    }

}
