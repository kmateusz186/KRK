package com.capgemini.krk.TO.educationProgram;

import java.util.List;

public class EducationProgramsTO {

    private List<EducationProgramTO> educationPrograms;

    public EducationProgramsTO(List<EducationProgramTO> educationPrograms) {
        this.educationPrograms = educationPrograms;
    }

    public EducationProgramsTO() {
    }

    public List<EducationProgramTO> getEducationPrograms() {
        return educationPrograms;
    }

    public void setEducationPrograms(List<EducationProgramTO> educationPrograms) {
        this.educationPrograms = educationPrograms;
    }
}