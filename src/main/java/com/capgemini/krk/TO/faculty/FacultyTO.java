package com.capgemini.krk.TO.faculty;

import lombok.*;

public class FacultyTO {
    private int id;
    private String name;

    public FacultyTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public FacultyTO() {
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