package com.capgemini.krk.TO.educationLevel;

import lombok.*;

public class EducationLevelTO {
    private int id;
    private String name;

    public EducationLevelTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public EducationLevelTO() {
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
