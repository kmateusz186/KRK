package com.capgemini.krk.TO.courseForm;

public class CourseFormTO {
    private int id;
    private String name;

    public CourseFormTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CourseFormTO() {
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
