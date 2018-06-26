package com.capgemini.krk.TO.coursesGroup;

import com.capgemini.krk.TO.course.CourseTO;

import java.util.List;

public class CoursesGroupTO {
    private int id;
    private String name;
    private List<CourseTO> courses;

    public CoursesGroupTO(int id, String name, List<CourseTO> courses) {
        this.id = id;
        this.name = name;
        this.courses = courses;
    }

    public CoursesGroupTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseTO> courses) {
        this.courses = courses;
    }
}
