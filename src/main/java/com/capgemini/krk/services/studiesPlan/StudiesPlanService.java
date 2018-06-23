package com.capgemini.krk.services.studiesPlan;

import com.capgemini.krk.TO.semester.SemesterTO;
import com.capgemini.krk.TO.studiesPlan.StudiesPlanTO;
import com.capgemini.krk.TO.studiesPlan.StudiesPlansTO;

public interface StudiesPlanService {

    void saveState(int id, StudiesPlansTO studiesPlansTO);

    StudiesPlansTO findAll();

    StudiesPlanTO findById(int id);

    StudiesPlansTO findByEducationProgramId(int id);

    void delete(int id);

    void updateStudiesPlan(StudiesPlanTO studiesPlan);

    StudiesPlanTO insertStudiesPlan(StudiesPlanTO studiesPlan);

}
