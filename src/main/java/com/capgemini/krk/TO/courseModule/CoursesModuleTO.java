package com.capgemini.krk.TO.courseModule;

import com.capgemini.krk.TO.moduleType.ModuleTypeTO;
import com.capgemini.krk.TO.semester.SemesterTO;

import java.util.List;

public class CoursesModuleTO {

    private int id;
    private ModuleTypeTO moduleType;
    //private List<CourseTO> courses;
    private List<SemesterTO> semesters;

   /* public CoursesModuleTO(int id, ModuleTypeTO moduleType, List<CourseTO> courses, List<SemesterTO> semesters) {
        this.id = id;
        this.moduleType = moduleType;
        this.courses = courses;
        this.semesters = semesters;
    } */

    public CoursesModuleTO(int id, ModuleTypeTO moduleType, List<SemesterTO> semesters) {
        this.id = id;
        this.moduleType = moduleType;
        this.semesters = semesters;
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
}
