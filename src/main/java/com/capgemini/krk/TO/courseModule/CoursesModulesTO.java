package com.capgemini.krk.TO.courseModule;

import java.util.List;

public class CoursesModulesTO {

    private List<CoursesModuleTO> coursesModules;

    public CoursesModulesTO(List<CoursesModuleTO> coursesModules) {
        this.coursesModules = coursesModules;
    }

    public CoursesModulesTO() {
    }

    public List<CoursesModuleTO> getCoursesModules() {
        return coursesModules;
    }

    public void setCoursesModules(List<CoursesModuleTO> coursesModules) {
        this.coursesModules = coursesModules;
    }
}
