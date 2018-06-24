package com.capgemini.krk.services.coursesModule;

import com.capgemini.krk.TO.courseModule.CoursesModuleTO;
import com.capgemini.krk.TO.courseModule.CoursesModulesTO;
import com.capgemini.krk.TO.studiesPlan.StudiesPlanTO;
import com.capgemini.krk.TO.studiesPlan.StudiesPlansTO;

public interface CoursesModuleService {

    void saveState(int id, CoursesModuleTO coursesModule);

    CoursesModulesTO findAll();

    CoursesModuleTO findById(int id);

    CoursesModulesTO findBySemesterId(int id);

    CoursesModulesTO findByOvModuleId(int id);

    void delete(int id);

    void updateCoursesModule(CoursesModuleTO coursesModule);

    CoursesModuleTO insertCoursesModule(int semesterId, CoursesModuleTO coursesModule);

    CoursesModuleTO insertCoursesModuleOv(CoursesModuleTO coursesModule);

}
