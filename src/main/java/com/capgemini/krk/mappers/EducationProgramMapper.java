package com.capgemini.krk.mappers;

import com.capgemini.krk.TO.educationLevel.EducationLevelTO;
import com.capgemini.krk.TO.educationProgram.EducationProgramTO;
import com.capgemini.krk.TO.faculty.FacultyTO;
import com.capgemini.krk.TO.mode.ModeTO;
import com.capgemini.krk.TO.profile.ProfileTO;
import com.capgemini.krk.entities.*;
import org.modelmapper.ModelMapper;

public class EducationProgramMapper {

    private static ModelMapper mapper = new ModelMapper();

    public static EducationprogramEntity mapToEntity(EducationProgramTO educationProgramTO) {
        EducationprogramEntity educationprogramEntity = mapper.map(educationProgramTO, EducationprogramEntity.class);
        educationprogramEntity.setId(educationProgramTO.getId());
        educationprogramEntity.setCourse(educationProgramTO.getCourse());
        FacultyEntity facultyEntity = mapper.map(educationProgramTO.getFaculty(), FacultyEntity.class);
        facultyEntity.setId(educationProgramTO.getFaculty().getId());
        facultyEntity.setName(educationProgramTO.getFaculty().getName());
        educationprogramEntity.setFaculty(facultyEntity);
        EducationlevelEntity educationlevelEntity = mapper.map(educationProgramTO.getLevel(), EducationlevelEntity.class);
        educationlevelEntity.setId(educationProgramTO.getLevel().getId());
        educationlevelEntity.setName(educationProgramTO.getLevel().getName());
        educationprogramEntity.setLevel(educationlevelEntity);
        ModeEntity modeEntity = mapper.map(educationProgramTO.getMode(), ModeEntity.class);
        modeEntity.setId(educationProgramTO.getMode().getId());
        modeEntity.setName(educationProgramTO.getMode().getName());
        educationprogramEntity.setMode(modeEntity);
        ProfileEntity profileEntity = mapper.map(educationProgramTO.getProfile(), ProfileEntity.class);
        profileEntity.setId(educationProgramTO.getProfile().getId());
        profileEntity.setName(educationProgramTO.getProfile().getName());
        educationprogramEntity.setProfile(profileEntity);
        educationprogramEntity.setPeriod(educationProgramTO.getPeriod());
        educationprogramEntity.setSpecialization(educationProgramTO.getSpecialization());
        return educationprogramEntity;
    }

    public static EducationProgramTO mapToTO(EducationprogramEntity educationProgram) {
        int id = educationProgram.getId();
        EducationLevelTO educationLevelTO = new EducationLevelTO(educationProgram.getLevel().getId(),educationProgram.getLevel().getName());
        ProfileTO profileTO = new ProfileTO(educationProgram.getProfile().getId(),educationProgram.getProfile().getName());
        String course = educationProgram.getCourse();
        String specialization = educationProgram.getSpecialization();
        ModeTO modeTO = new ModeTO(educationProgram.getMode().getId(),educationProgram.getMode().getName());
        String period = educationProgram.getPeriod();
        FacultyTO facultyTO = new FacultyTO(educationProgram.getFaculty().getId(), educationProgram.getFaculty().getName());
        EducationProgramTO educationProgramTO = new EducationProgramTO(id, educationLevelTO, profileTO, course, specialization, modeTO, period, facultyTO);
        return educationProgramTO;
    }

}
