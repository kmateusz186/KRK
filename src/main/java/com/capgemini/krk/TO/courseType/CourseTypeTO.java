package com.capgemini.krk.TO.courseType;

public class CourseTypeTO {
    private int id;
    private String name;

    public CourseTypeTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CourseTypeTO() {
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
}
