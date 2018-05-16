package com.capgemini.krk.mappers;

import com.capgemini.krk.TO.ChangeSuggestion.ChangeSuggestionTO;
import com.capgemini.krk.TO.educationLevel.EducationLevelTO;
import com.capgemini.krk.TO.educationProgram.EducationProgramTO;
import com.capgemini.krk.TO.evaluator.EvaluatorTO;
import com.capgemini.krk.TO.faculty.FacultyTO;
import com.capgemini.krk.TO.mode.ModeTO;
import com.capgemini.krk.TO.profile.ProfileTO;
import com.capgemini.krk.entities.*;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class ChangeSuggestionMapper {

    private static ModelMapper mapper = new ModelMapper();

    public static ChangesuggestionEntity mapToEntity(ChangeSuggestionTO changeSuggestionTO) {
        ChangesuggestionEntity changeSuggestion = mapper.map(changeSuggestionTO, ChangesuggestionEntity.class);
        changeSuggestion.setId(changeSuggestionTO.getId());
        changeSuggestion.setProposition(changeSuggestionTO.getProposition());
        changeSuggestion.setReason(changeSuggestionTO.getReason());
        EducationprogramEntity educationprogramEntity = null;
        educationprogramEntity.setId(changeSuggestionTO.getEducationProgram().getId());
        educationprogramEntity.setCourse(changeSuggestionTO.getEducationProgram().getCourse());
        FacultyEntity facultyEntity = null;
        facultyEntity.setId(changeSuggestionTO.getEducationProgram().getFaculty().getId());
        facultyEntity.setName(changeSuggestionTO.getEducationProgram().getFaculty().getName());
        educationprogramEntity.setFaculty(facultyEntity);
        EducationlevelEntity educationlevelEntity = null;
        educationlevelEntity.setId(changeSuggestionTO.getEducationProgram().getLevel().getId());
        educationlevelEntity.setName(changeSuggestionTO.getEducationProgram().getLevel().getName());
        educationprogramEntity.setLevel(educationlevelEntity);
        ModeEntity modeEntity = null;
        modeEntity.setId(changeSuggestionTO.getEducationProgram().getMode().getId());
        modeEntity.setName(changeSuggestionTO.getEducationProgram().getMode().getName());
        educationprogramEntity.setMode(modeEntity);
        ProfileEntity profileEntity = null;
        profileEntity.setId(changeSuggestionTO.getEducationProgram().getProfile().getId());
        profileEntity.setName(changeSuggestionTO.getEducationProgram().getProfile().getName());
        educationprogramEntity.setProfile(profileEntity);
        educationprogramEntity.setPeriod(changeSuggestionTO.getEducationProgram().getPeriod());
        educationprogramEntity.setSpecialization(changeSuggestionTO.getEducationProgram().getSpecialization());
        changeSuggestion.setEducationProgram(educationprogramEntity);
        EvaluatorEntity evaluatorEntity = null;
        evaluatorEntity.setId(changeSuggestionTO.getEvaluator().getId());
        evaluatorEntity.setName(changeSuggestionTO.getEvaluator().getName());
        evaluatorEntity.setSurname(changeSuggestionTO.getEvaluator().getSurname());
        changeSuggestion.setEvaluator(evaluatorEntity);
        return changeSuggestion;
    }

    public static ChangeSuggestionTO mapToTO(ChangesuggestionEntity changeSuggestion) {
        EducationprogramEntity educationProgram = changeSuggestion.getEducationProgram();
        int idEp = educationProgram.getId();
        EducationLevelTO educationLevelTO = new EducationLevelTO(educationProgram.getLevel().getId(),educationProgram.getLevel().getName());
        ProfileTO profileTO = new ProfileTO(educationProgram.getProfile().getId(),educationProgram.getProfile().getName());
        String course = educationProgram.getCourse();
        String specialization = educationProgram.getSpecialization();
        ModeTO modeTO = new ModeTO(educationProgram.getMode().getId(),educationProgram.getMode().getName());
        String period = educationProgram.getPeriod();
        FacultyTO facultyTO = new FacultyTO(educationProgram.getFaculty().getId(), educationProgram.getFaculty().getName());
        EducationProgramTO educationProgramTO = new EducationProgramTO(idEp, educationLevelTO, profileTO, course, specialization, modeTO, period, facultyTO);
        EvaluatorTO evaluatorTO = new EvaluatorTO(changeSuggestion.getEvaluator().getId(), changeSuggestion.getEvaluator().getName(), changeSuggestion.getEvaluator().getSurname());
        int id = changeSuggestion.getId();
        String proposition = changeSuggestion.getProposition();
        String reason = changeSuggestion.getReason();
        ChangeSuggestionTO changeSuggestionTO = new ChangeSuggestionTO(id, evaluatorTO, educationProgramTO, proposition, reason);

        return changeSuggestionTO;
    }

}
