package com.capgemini.krk.TO.courseModule;

import com.capgemini.krk.TO.course.CourseTO;
import com.capgemini.krk.TO.moduleType.ModuleTypeTO;
import com.capgemini.krk.TO.semester.SemesterTO;

import java.util.List;

public class CoursesModuleTO {

    private int id;
    private ModuleTypeTO moduleType;
    private CoursesModuleTO ovModule;
    private List<CourseTO> courses;
    private List<SemesterTO> semesters;
    private List<CoursesModuleTO> ovModules;

    public CoursesModuleTO(int id, ModuleTypeTO moduleType, CoursesModuleTO ovModule, List<CourseTO> courses, List<SemesterTO> semesters, List<CoursesModuleTO> ovModules) {
        this.id = id;
        this.moduleType = moduleType;
        this.ovModule = ovModule;
        this.courses = courses;
        this.semesters = semesters;
        this.ovModules = ovModules;
    }

    public CoursesModuleTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ModuleTypeTO getModuleType() {
        return moduleType;
    }

    public void setModuleType(ModuleTypeTO moduleType) {
        this.moduleType = moduleType;
    }

    public List<SemesterTO> getSemesters() {
        return semesters;
    }

    public void setSemesters(List<SemesterTO> semesters) {
        this.semesters = semesters;
    }

    public CoursesModuleTO getOvModule() {
        return ovModule;
    }

    public void setOvModule(CoursesModuleTO ovModule) {
        this.ovModule = ovModule;
    }

    public List<CourseTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseTO> courses) {
        this.courses = courses;
    }

    public List<CoursesModuleTO> getOvModules() {
        return ovModules;
    }

    public void setOvModules(List<CoursesModuleTO> ovModules) {
        this.ovModules = ovModules;
    }
}
