package com.capgemini.krk.TO.studiesProgram;

import com.capgemini.krk.TO.educationProgram.EducationProgramTO;

public class StudiesProgramTO {

    private int id;
    private String description;
    private EducationProgramTO educationProgram;

    public StudiesProgramTO(int id, String description, EducationProgramTO educationProgram) {
        this.id = id;
        this.description = description;
        this.educationProgram = educationProgram;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EducationProgramTO getEducationProgram() {
        return educationProgram;
    }

    public void setEducationProgram(EducationProgramTO educationProgram) {
        this.educationProgram = educationProgram;
    }
}
