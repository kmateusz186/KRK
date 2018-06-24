package com.capgemini.krk.rest.coursesModule;

import com.capgemini.krk.TO.courseModule.CoursesModuleTO;
import com.capgemini.krk.TO.courseModule.CoursesModulesTO;
import com.capgemini.krk.services.coursesModule.CoursesModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/gui")
public class CoursesModuleRestServiceGUI {

    @Autowired
    private CoursesModuleService coursesModuleService;

    @RequestMapping(value = "/courses-modules", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CoursesModulesTO findAll() {
        CoursesModulesTO coursesModulesTO =  coursesModuleService.findAll();
        return coursesModulesTO;
    }

    @RequestMapping(value = "/courses-modules-overview/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CoursesModulesTO findBySemesterId(@PathVariable int id) {
        CoursesModulesTO coursesModulesTO =  coursesModuleService.findBySemesterId(id);
        return coursesModulesTO;
    }

    @RequestMapping(value = "/courses-modules-ov-overview/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CoursesModulesTO findByOvModuleId(@PathVariable int id) {
        CoursesModulesTO coursesModulesTO =  coursesModuleService.findByOvModuleId(id);
        return coursesModulesTO;
    }

    @RequestMapping(value = "courses-modules/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CoursesModuleTO findById(@PathVariable int id) {
        CoursesModuleTO coursesModuleTO = coursesModuleService.findById(id);
        return coursesModuleTO;
    }

    @RequestMapping(value = "/courses-modules/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        coursesModuleService.delete(id);
    }


    @RequestMapping(value = "/courses-modules-up", method = RequestMethod.PUT)
    public void update(@RequestBody CoursesModuleTO coursesModuleTO) {
        coursesModuleService.updateCoursesModule(coursesModuleTO);
    }

    @RequestMapping(value = "/courses-modules-in-ov", method = RequestMethod.PUT)
    public void insertOv(@RequestBody CoursesModuleTO coursesModuleTO) {
        coursesModuleService.insertCoursesModuleOv(coursesModuleTO);
    }

    @RequestMapping(value = "/courses-modules-in/{semesterId}", method = RequestMethod.PUT)
    public void insert(@PathVariable int semesterId, @RequestBody CoursesModuleTO coursesModuleTO) {
        coursesModuleService.insertCoursesModule(semesterId, coursesModuleTO);
    }

}
