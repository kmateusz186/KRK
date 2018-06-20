package com.capgemini.krk.TO.educationProgram;

import java.util.List;

public class EducationProgramsTO {

    private List<EducationProgramTO> educationPrograms;

    public EducationProgramsTO(List<EducationProgramTO> changeSuggestions) {
        this.educationPrograms = changeSuggestions;
    }

    public EducationProgramsTO() {
    }

    public List<EducationProgramTO> getChangeSuggestions() {
        return educationPrograms;
    }

    public void setChangeSuggestions(List<EducationProgramTO> educationPrograms) {
        this.educationPrograms = educationPrograms;
    }
}