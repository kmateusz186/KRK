package com.capgemini.krk.services.educationProgram;


import com.capgemini.krk.TO.educationProgram.EducationProgramTO;
import com.capgemini.krk.TO.educationProgram.EducationProgramsTO;

public interface EducationProgramService {

    void saveState(int id, EducationProgramsTO educationProgramsTO);

    EducationProgramsTO findAll();

    EducationProgramTO findById(int id);

    void delete(int id);

    void updateEducationProgramPeriod(EducationProgramTO educationProgram);

}
