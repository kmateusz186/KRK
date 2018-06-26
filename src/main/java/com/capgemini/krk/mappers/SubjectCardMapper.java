package com.capgemini.krk.mappers;

import com.capgemini.krk.TO.areaOfKnowledge.AreaOfKnowledgeTO;
import com.capgemini.krk.TO.classesType.ClassesTypeTO;
import com.capgemini.krk.TO.courseEducationEffect.CourseEducationEffectTO;
import com.capgemini.krk.TO.educationLevel.EducationLevelTO;
import com.capgemini.krk.TO.educationProgram.EducationProgramTO;
import com.capgemini.krk.TO.eeCategory.EECategoryTO;
import com.capgemini.krk.TO.faculty.FacultyTO;
import com.capgemini.krk.TO.mode.ModeTO;
import com.capgemini.krk.TO.profile.ProfileTO;
import com.capgemini.krk.TO.programContent.ProgramContentTO;
import com.capgemini.krk.TO.scienceArea.ScienceAreaTO;
import com.capgemini.krk.TO.subject.SubjectTO;
import com.capgemini.krk.TO.subjectCard.SubjectCardTO;
import com.capgemini.krk.TO.subjectEducationEffect.SubjectEducationEffectTO;
import com.capgemini.krk.TO.subjectKeeper.SubjectKeeperTO;
import com.capgemini.krk.TO.subjectPurpose.SubjectPurposeTO;
import com.capgemini.krk.TO.teachingTool.TeachingToolTO;
import com.capgemini.krk.entities.*;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class SubjectCardMapper {

    private static ModelMapper mapper = new ModelMapper();

    public static SubjectcardEntity mapToEntity(SubjectCardTO subjectCardTO) {
        SubjectcardEntity subjectcardEntity = mapper.map(subjectCardTO, SubjectcardEntity.class);
        subjectcardEntity.setId(subjectCardTO.getId());
        subjectcardEntity.setLink(subjectCardTO.getLink());
        List<ProgramcontentEntity> programcontentEntities = new ArrayList<>();
        for (ProgramContentTO programContentTO : subjectCardTO.getProgramContents()) {
            ProgramcontentEntity programcontentEntity = mapper.map(programContentTO, ProgramcontentEntity.class);
            programcontentEntity.setId(programContentTO.getId());
            ClassestypeEntity classestypeEntity = mapper.map(programContentTO.getClassesType(), ClassestypeEntity.class);
            classestypeEntity.setId(programContentTO.getClassesType().getId());
            classestypeEntity.setName(programContentTO.getClassesType().getName());
            programcontentEntity.setClassesType(classestypeEntity);
            programcontentEntity.setContent(programContentTO.getContent());
            programcontentEntity.setHours(programContentTO.getHours());
            programcontentEntity.setSymbol(programContentTO.getSymbol());
            programcontentEntities.add(programcontentEntity);
        }
        subjectcardEntity.setProgramContents(programcontentEntities);
        SubjectEntity subjectEntity = mapper.map(subjectCardTO.getSubject(), SubjectEntity.class);
        subjectEntity.setId(subjectCardTO.getSubject().getId());
        subjectEntity.setCode(subjectCardTO.getSubject().getCode());
        subjectEntity.setNamePl(subjectCardTO.getSubject().getNamePL());
        subjectEntity.setNameEng(subjectCardTO.getSubject().getNameEng());
        subjectEntity.setPrerequisites(subjectCardTO.getSubject().getPrerequisites());
        //TODO
        return subjectcardEntity;
    }

    public static SubjectCardTO mapToTO(SubjectcardEntity subjectCard) {
        int id = subjectCard.getId();
        String link = subjectCard.getLink();
        List<ProgramContentTO> programContentsTO = new ArrayList<>();
        for (ProgramcontentEntity programcontentEntity : subjectCard.getProgramContents()) {
            ClassesTypeTO classesTypeTO = new ClassesTypeTO(programcontentEntity.getClassesType().getId(), programcontentEntity.getClassesType().getName());
            ProgramContentTO programContentTO = new ProgramContentTO(programcontentEntity.getId(),programcontentEntity.getSymbol(), programcontentEntity.getContent(), programcontentEntity.getHours(), classesTypeTO, null);
            programContentsTO.add(programContentTO);
        }
        List<CourseEducationEffectTO> courseEducationEffectsTO = new ArrayList<>();
        for (CourseeducationeffectEntity courseeducationeffectEntity : subjectCard.getSubject().getCourseEducationEffects()) {
            AreaOfKnowledgeTO areaOfKnowledgeTO = new AreaOfKnowledgeTO(courseeducationeffectEntity.getAreaOfKnowledge().getId(), courseeducationeffectEntity.getAreaOfKnowledge().getName());
            EECategoryTO eeCategoryTO = new EECategoryTO(courseeducationeffectEntity.getCategory().getId(), courseeducationeffectEntity.getCategory().getName());
            ScienceAreaTO scienceAreaTO = new ScienceAreaTO(courseeducationeffectEntity.getScienceArea().getId(), courseeducationeffectEntity.getScienceArea().getName());
            List<SubjectEducationEffectTO> subjectEducationEffectsCourseTO = new ArrayList<>();
            for (SubjecteducationeffectEntity subjecteducationeffectEntity : courseeducationeffectEntity.getSubjectEducationEffects()) {
                SubjectEducationEffectTO subjectEducationEffectTO = new SubjectEducationEffectTO(subjecteducationeffectEntity.getId(), subjecteducationeffectEntity.getSymbol());
                subjectEducationEffectsCourseTO.add(subjectEducationEffectTO);
            }
            CourseEducationEffectTO courseEducationEffectTO = new CourseEducationEffectTO(courseeducationeffectEntity.getId(), courseeducationeffectEntity.getSymbol(), courseeducationeffectEntity.getEducationEffect(), courseeducationeffectEntity.getComponentCode(), areaOfKnowledgeTO, eeCategoryTO, scienceAreaTO, null, subjectEducationEffectsCourseTO);
            courseEducationEffectsTO.add(courseEducationEffectTO);
        }
        SubjectTO subjectTO = new SubjectTO(subjectCard.getSubject().getId(), subjectCard.getSubject().getNamePl(), subjectCard.getSubject().getNameEng(), subjectCard.getSubject().getCode(), subjectCard.getSubject().getPrerequisites(), courseEducationEffectsTO);
        List<TeachingToolTO> teachingToolsTO = new ArrayList<>();
        for (TeachingtoolEntity teachingtoolEntity : subjectCard.getTeachingTools()) {
            TeachingToolTO teachingToolTO = new TeachingToolTO(teachingtoolEntity.getId(), teachingtoolEntity.getSymbol(), teachingtoolEntity.getTool(), null);
            teachingToolsTO.add(teachingToolTO);
        }
        List<SubjectEducationEffectTO> subjectEducationEffectsTO =  new ArrayList<>();
        for (SubjecteducationeffectEntity subjecteducationeffectEntity : subjectCard.getSubjectEducationEffects()) {
            EECategoryTO eeCategoryTOTMP = new EECategoryTO(subjecteducationeffectEntity.getCategory().getId(), subjecteducationeffectEntity.getCategory().getName());
            List<CourseEducationEffectTO> courseEducationEffectsTOTMP = new ArrayList<>();
            for (CourseeducationeffectEntity courseeducationeffectEntityTMP : subjectCard.getSubject().getCourseEducationEffects()) {
                CourseEducationEffectTO courseEducationEffectTOTMP = new CourseEducationEffectTO(courseeducationeffectEntityTMP.getId(), courseeducationeffectEntityTMP.getSymbol());
                courseEducationEffectsTOTMP.add(courseEducationEffectTOTMP);
            }
            SubjectEducationEffectTO subjectEducationEffectTOTMP = new SubjectEducationEffectTO(subjecteducationeffectEntity.getId(), subjecteducationeffectEntity.getSymbol(), subjecteducationeffectEntity.getEducationEffect(), eeCategoryTOTMP, courseEducationEffectsTOTMP);
            subjectEducationEffectsTO.add(subjectEducationEffectTOTMP);
        }
        List<SubjectKeeperTO> subjectKeepersTO = new ArrayList<>();
        for (SubjectkeeperEntity subjectkeeperEntity : subjectCard.getSubjectKeepers()) {
            SubjectKeeperTO subjectKeeperTO = new SubjectKeeperTO(subjectkeeperEntity.getId(), subjectkeeperEntity.getName(), subjectkeeperEntity.getSurname(), null);
            subjectKeepersTO.add(subjectKeeperTO);
        }
        List<SubjectPurposeTO> subjectPurposesTO = new ArrayList<>();
        for (SubjectpurposeEntity subjectpurposeEntity : subjectCard.getSubjectPurposes()) {
            SubjectPurposeTO subjectPurposeTO = new SubjectPurposeTO(subjectpurposeEntity.getId(), subjectpurposeEntity.getSymbol(), subjectpurposeEntity.getPurpose(), null);
            subjectPurposesTO.add(subjectPurposeTO);
        }
        SubjectCardTO subjectCardTO = new SubjectCardTO(id, link, programContentsTO, subjectTO, teachingToolsTO, subjectEducationEffectsTO, subjectKeepersTO, subjectPurposesTO);
        return subjectCardTO;
    }
}
