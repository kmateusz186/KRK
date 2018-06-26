package com.capgemini.krk.TO.course;

import java.util.List;

public class CoursesTO {
    private List<CourseTO> courses;

    public CoursesTO(List<CourseTO> courses) {
        this.courses = courses;
    }

    public CoursesTO() {
    }

    public List<CourseTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseTO> courses) {
        this.courses = courses;
    }
}
