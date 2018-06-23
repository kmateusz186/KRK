package com.capgemini.krk.TO.studiesPlan;

import java.util.List;

public class StudiesPlansTO {

    private List<StudiesPlanTO> studiesPlans;

    public StudiesPlansTO(List<StudiesPlanTO> educationPrograms) {
        this.studiesPlans = educationPrograms;
    }

    public StudiesPlansTO() {
    }

    public List<StudiesPlanTO> getStudiesPlans() {
        return studiesPlans;
    }

    public void setStudiesPlans(List<StudiesPlanTO> studiesPlans) {
        this.studiesPlans = studiesPlans;
    }
}
