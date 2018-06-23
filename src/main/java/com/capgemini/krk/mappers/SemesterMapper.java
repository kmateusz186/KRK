package com.capgemini.krk.mappers;

import com.capgemini.krk.TO.courseModule.CoursesModuleTO;
import com.capgemini.krk.TO.semester.SemesterTO;
import com.capgemini.krk.TO.studiesPlan.StudiesPlanTO;
import com.capgemini.krk.entities.*;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class SemesterMapper {

    private static ModelMapper mapper = new ModelMapper();

    public static SemesterEntity mapToEntity(SemesterTO semesterTO) {
        SemesterEntity semesterEntity = mapper.map(semesterTO, SemesterEntity.class);
        semesterEntity.setId(semesterTO.getId());
        semesterEntity.setNumber(semesterTO.getNumber());
        List<CoursesmoduleEntity> coursesModules = new ArrayList<>();
        for (CoursesModuleTO coursesModuleTO : semesterTO.getCoursesModules()) {
            CoursesmoduleEntity coursesModuleTMP = mapper.map(coursesModuleTO, CoursesmoduleEntity.class);
            coursesModuleTMP.setId(coursesModuleTO.getId());
            coursesModules.add(coursesModuleTMP);
        }
        semesterEntity.setCoursesModules(coursesModules);
        StudiesplanEntity studiesplanEntity = mapper.map(semesterTO.getStudiesPlan(), StudiesplanEntity.class);
        studiesplanEntity.setId(semesterTO.getId());
        semesterEntity.setStudiesPlan(studiesplanEntity);
        return semesterEntity;
    }

    public static SemesterTO mapToTO(SemesterEntity semester) {
        int id = semester.getId();
        int number = semester.getNumber();
        StudiesPlanTO studiesPlanTO = new StudiesPlanTO();
        studiesPlanTO.setId(semester.getStudiesPlan().getId());
        List<CoursesModuleTO> coursesModules = new ArrayList<>();
        for (CoursesmoduleEntity coursesmoduleEntity : semester.getCoursesModules()) {
            CoursesModuleTO coursesModuleTMP = new CoursesModuleTO();
            coursesModuleTMP.setId(coursesmoduleEntity.getId());
            coursesModules.add(coursesModuleTMP);
        }
        SemesterTO semesterTO = new SemesterTO(id, number, studiesPlanTO, coursesModules);
        return semesterTO;
    }
}
