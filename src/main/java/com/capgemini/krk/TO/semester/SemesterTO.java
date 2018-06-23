package com.capgemini.krk.TO.semester;

import com.capgemini.krk.TO.courseModule.CoursesModuleTO;
import com.capgemini.krk.TO.studiesPlan.StudiesPlanTO;

import java.util.List;

public class SemesterTO {

    private int id;
    private int number;
    private StudiesPlanTO studiesPlan;
    private List<CoursesModuleTO> coursesModules;

    public SemesterTO(int id, int number, StudiesPlanTO studiesPlan, List<CoursesModuleTO> coursesModules) {
        this.id = id;
        this.number = number;
        this.studiesPlan = studiesPlan;
        this.coursesModules = coursesModules;
    }

    public SemesterTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public StudiesPlanTO getStudiesPlan() {
        return studiesPlan;
    }

    public void setStudiesPlan(StudiesPlanTO studiesPlan) {
        this.studiesPlan = studiesPlan;
    }

    public List<CoursesModuleTO> getCoursesModules() {
        return coursesModules;
    }

    public void setCoursesModules(List<CoursesModuleTO> coursesModules) {
        this.coursesModules = coursesModules;
    }
}
