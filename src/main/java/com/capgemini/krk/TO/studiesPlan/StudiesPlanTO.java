package com.capgemini.krk.TO.studiesPlan;

import com.capgemini.krk.TO.educationProgram.EducationProgramTO;

public class StudiesPlanTO {

    private int id;
    private EducationProgramTO educationProgram;

    public StudiesPlanTO(int id, EducationProgramTO educationProgram) {
        this.id = id;
        this.educationProgram = educationProgram;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EducationProgramTO getEducationProgram() {
        return educationProgram;
    }

    public void setEducationProgram(EducationProgramTO educationProgram) {
        this.educationProgram = educationProgram;
    }
}
