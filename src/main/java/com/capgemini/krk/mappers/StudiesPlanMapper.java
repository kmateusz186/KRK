package com.capgemini.krk.mappers;

import com.capgemini.krk.TO.course.CourseTO;
import com.capgemini.krk.TO.course.CoursesTO;
import com.capgemini.krk.TO.courseModule.CoursesModuleTO;
import com.capgemini.krk.TO.educationLevel.EducationLevelTO;
import com.capgemini.krk.TO.educationProgram.EducationProgramTO;
import com.capgemini.krk.TO.faculty.FacultyTO;
import com.capgemini.krk.TO.mode.ModeTO;
import com.capgemini.krk.TO.moduleType.ModuleTypeTO;
import com.capgemini.krk.TO.profile.ProfileTO;
import com.capgemini.krk.TO.semester.SemesterTO;
import com.capgemini.krk.TO.studiesPlan.StudiesPlanTO;
import com.capgemini.krk.entities.*;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class StudiesPlanMapper {

    private static ModelMapper mapper = new ModelMapper();

    public static StudiesplanEntity mapToEntity(StudiesPlanTO studiesplanTO) {
        StudiesplanEntity studiesplanEntity = mapper.map(studiesplanTO, StudiesplanEntity.class);
        studiesplanEntity.setId(studiesplanTO.getId());
        List<SemesterEntity> semesters = new ArrayList<>();
        for(SemesterTO semesterTO : studiesplanTO.getSemesters()) {
            SemesterEntity semesterTMP = mapper.map(semesterTO, SemesterEntity.class);
            semesterTMP.setId(semesterTO.getId());
            semesterTMP.setNumber(semesterTO.getNumber());
            List<CoursesmoduleEntity> coursesModules = new ArrayList<>();
            for(CoursesModuleTO coursesModuleTO : semesterTO.getCoursesModules()) {
                CoursesmoduleEntity coursesModuleTMP = mapper.map(coursesModuleTO, CoursesmoduleEntity.class);
                coursesModuleTMP.setId(coursesModuleTO.getId());
                coursesModules.add(coursesModuleTMP);
            }
            semesterTMP.setCoursesModules(coursesModules);
            semesters.add(semesterTMP);
        }
        studiesplanEntity.setSemesters(semesters);
        EducationprogramEntity educationprogramEntity = mapper.map(studiesplanTO.getEducationProgram(), EducationprogramEntity.class);
        educationprogramEntity.setId(studiesplanTO.getEducationProgram().getId());
        educationprogramEntity.setCourse(studiesplanTO.getEducationProgram().getCourse());
        FacultyEntity facultyEntity = null;
        if (studiesplanTO.getEducationProgram().getFaculty() != null) {
            facultyEntity = mapper.map(studiesplanTO.getEducationProgram().getFaculty(), FacultyEntity.class);
            facultyEntity.setId(studiesplanTO.getEducationProgram().getFaculty().getId());
            facultyEntity.setName(studiesplanTO.getEducationProgram().getFaculty().getName());
        }
        educationprogramEntity.setFaculty(facultyEntity);
        EducationlevelEntity educationlevelEntity = null;
        if (studiesplanTO.getEducationProgram().getLevel() != null) {
            educationlevelEntity = mapper.map(studiesplanTO.getEducationProgram().getLevel(), EducationlevelEntity.class);
            educationlevelEntity.setId(studiesplanTO.getEducationProgram().getLevel().getId());
            educationlevelEntity.setName(studiesplanTO.getEducationProgram().getLevel().getName());
        }
        educationprogramEntity.setLevel(educationlevelEntity);
        ModeEntity modeEntity = null;
        if (studiesplanTO.getEducationProgram().getMode() != null) {
            modeEntity = mapper.map(studiesplanTO.getEducationProgram().getMode(), ModeEntity.class);
            modeEntity.setId(studiesplanTO.getEducationProgram().getMode().getId());
            modeEntity.setName(studiesplanTO.getEducationProgram().getMode().getName());
        }
        educationprogramEntity.setMode(modeEntity);
        ProfileEntity profileEntity = null;
        if (studiesplanTO.getEducationProgram().getProfile() != null) {
            profileEntity = mapper.map(studiesplanTO.getEducationProgram().getProfile(), ProfileEntity.class);
            profileEntity.setId(studiesplanTO.getEducationProgram().getProfile().getId());
            profileEntity.setName(studiesplanTO.getEducationProgram().getProfile().getName());
        }
        educationprogramEntity.setProfile(profileEntity);
        educationprogramEntity.setPeriod(studiesplanTO.getEducationProgram().getPeriod());
        educationprogramEntity.setSpecialization(studiesplanTO.getEducationProgram().getSpecialization());
        studiesplanEntity.setEducationProgram(educationprogramEntity);
        return studiesplanEntity;
    }

    public static StudiesPlanTO mapToTO(StudiesplanEntity studiesPlan) {
        int id = studiesPlan.getId();
        List<SemesterTO> semesters = new ArrayList<>();
        for(SemesterEntity semesterEntity : studiesPlan.getSemesters()) {
            SemesterTO semesterTMP = new SemesterTO();
            semesterTMP.setId(semesterEntity.getId());
            semesterTMP.setNumber(semesterEntity.getNumber());
            List<CoursesModuleTO> coursesModules = new ArrayList<>();
            for(CoursesmoduleEntity coursesmoduleEntity : semesterEntity.getCoursesModules()) {
                CoursesModuleTO coursesModuleTMP = new CoursesModuleTO();
                coursesModuleTMP.setId(coursesmoduleEntity.getId());
                ModuleTypeTO moduleTypeTO = new ModuleTypeTO(coursesmoduleEntity.getModuleType().getId(), coursesmoduleEntity.getModuleType().getName());
                coursesModuleTMP.setModuleType(moduleTypeTO);
                List<CoursesModuleTO> coursesOvModulesTO = new ArrayList<>();
                for (CoursesmoduleEntity coursesovmoduleEntity : coursesmoduleEntity.getOvModules()) {
                    CoursesModuleTO coursesModuleTMPTMP = new CoursesModuleTO();
                    coursesModuleTMPTMP.setId(coursesovmoduleEntity.getId());
                    ModuleTypeTO moduleOvTypeTO = new ModuleTypeTO(coursesovmoduleEntity.getModuleType().getId(), coursesovmoduleEntity.getModuleType().getName());
                    coursesModuleTMPTMP.setModuleType(moduleOvTypeTO);
                    List<CoursesModuleTO> coursesOvOvModulesTO = new ArrayList<>();
                    for (CoursesmoduleEntity coursesovovmoduleEntity : coursesmoduleEntity.getOvModules()) {
                        CoursesModuleTO coursesModuleTMPTMPTMP = new CoursesModuleTO();
                        coursesModuleTMPTMPTMP.setId(coursesovovmoduleEntity.getId());
                        ModuleTypeTO moduleOvOvTypeTO = new ModuleTypeTO(coursesovovmoduleEntity.getModuleType().getId(), coursesovovmoduleEntity.getModuleType().getName());
                        coursesModuleTMPTMPTMP.setModuleType(moduleOvOvTypeTO);
                        List<CourseTO> coursesOvOvTO = new ArrayList<>();
                        for (CourseEntity courseOvOvEntity : coursesovovmoduleEntity.getCourses()) {
                            coursesOvOvTO.add(CourseMapper.mapToTO(courseOvOvEntity));
                        }
                        coursesModuleTMPTMPTMP.setCourses(coursesOvOvTO);
                        coursesOvOvModulesTO.add(coursesModuleTMPTMPTMP);
                    }
                    coursesModuleTMPTMP.setOvModules(coursesOvOvModulesTO);
                    List<CourseTO> coursesOvTO = new ArrayList<>();
                    for (CourseEntity courseOvEntity : coursesovmoduleEntity.getCourses()) {
                        coursesOvTO.add(CourseMapper.mapToTO(courseOvEntity));
                    }
                    coursesModuleTMPTMP.setCourses(coursesOvTO);
                    coursesOvModulesTO.add(coursesModuleTMPTMP);
                }
                coursesModuleTMP.setOvModules(coursesOvModulesTO);
                List<CourseTO> coursesTO = new ArrayList<>();
                for (CourseEntity courseEntity : coursesmoduleEntity.getCourses()) {
                    coursesTO.add(CourseMapper.mapToTO(courseEntity));
                }
                coursesModuleTMP.setCourses(coursesTO);
                coursesModules.add(coursesModuleTMP);
            }
            semesterTMP.setCoursesModules(coursesModules);
            semesters.add(semesterTMP);
        }
        int idEp = studiesPlan.getEducationProgram().getId();
        EducationLevelTO educationLevelTO = new EducationLevelTO(studiesPlan.getEducationProgram().getLevel().getId(),studiesPlan.getEducationProgram().getLevel().getName());
        ProfileTO profileTO = new ProfileTO(studiesPlan.getEducationProgram().getProfile().getId(),studiesPlan.getEducationProgram().getProfile().getName());
        String course = studiesPlan.getEducationProgram().getCourse();
        String specialization = studiesPlan.getEducationProgram().getSpecialization();
        ModeTO modeTO = new ModeTO(studiesPlan.getEducationProgram().getMode().getId(),studiesPlan.getEducationProgram().getMode().getName());
        String period = studiesPlan.getEducationProgram().getPeriod();
        FacultyTO facultyTO = new FacultyTO(studiesPlan.getEducationProgram().getFaculty().getId(), studiesPlan.getEducationProgram().getFaculty().getName());
        EducationProgramTO educationProgramTO = new EducationProgramTO(idEp, educationLevelTO, profileTO, course, specialization, modeTO, period, facultyTO);
        StudiesPlanTO studiesPlanTO = new StudiesPlanTO(id, semesters, educationProgramTO);
        return studiesPlanTO;
    }
}
