package com.capgemini.krk.TO.studiesPlan;

import com.capgemini.krk.TO.educationProgram.EducationProgramTO;
import com.capgemini.krk.TO.semester.SemesterTO;

import java.util.List;

public class StudiesPlanTO {

    private int id;
    private List<SemesterTO> semesters;
    private EducationProgramTO educationProgram;

    public StudiesPlanTO(int id, List<SemesterTO> semesters, EducationProgramTO educationProgram) {
        this.id = id;
        this.semesters = semesters;
        this.educationProgram = educationProgram;
    }

    public StudiesPlanTO() {
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

    public List<SemesterTO> getSemesters() {
        return semesters;
    }

    public void setSemesters(List<SemesterTO> semesters) {
        this.semesters = semesters;
    }
}
