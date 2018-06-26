package com.capgemini.krk.mappers;

import com.capgemini.krk.TO.classesType.ClassesTypeTO;
import com.capgemini.krk.TO.course.CourseTO;
import com.capgemini.krk.TO.courseEducationEffect.CourseEducationEffectTO;
import com.capgemini.krk.TO.courseForm.CourseFormTO;
import com.capgemini.krk.TO.courseType.CourseTypeTO;
import com.capgemini.krk.TO.coursesGroup.CoursesGroupTO;
import com.capgemini.krk.TO.kind.KindTO;
import com.capgemini.krk.TO.passingWay.PassingWayTO;
import com.capgemini.krk.TO.subject.SubjectTO;
import com.capgemini.krk.TO.subjectCard.SubjectCardTO;
import com.capgemini.krk.entities.*;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class CourseMapper {

    private static ModelMapper mapper = new ModelMapper();

    public static CourseEntity mapToEntity(CourseTO courseTO) {
        CourseEntity courseEntity = mapper.map(courseTO, CourseEntity.class);
        courseEntity.setId(courseTO.getId());
        courseEntity.setName(courseTO.getName());
        courseEntity.setEcts(courseTO.getEcts());
        courseEntity.setTechnical(courseTO.getTechnical());
        courseEntity.setCode(courseTO.getCode());
        courseEntity.setZzuHours(courseTO.getZzuHours());
        ClassestypeEntity classestypeEntity = mapper.map(courseTO.getClassesType(), ClassestypeEntity.class);
        classestypeEntity.setId(courseTO.getClassesType().getId());
        classestypeEntity.setName(courseTO.getClassesType().getName());
        courseEntity.setClassesType(classestypeEntity);
        CoursetypeEntity coursetypeEntity = mapper.map(courseTO.getCourseType(), CoursetypeEntity.class);
        coursetypeEntity.setId(courseTO.getCourseType().getId());
        coursetypeEntity.setName(courseTO.getCourseType().getName());
        courseEntity.setCourseType(coursetypeEntity);
        CoursesgroupEntity coursesgroupEntity = null;
        if (courseTO.getCoursesGroup() != null) {
            coursesgroupEntity = mapper.map(courseTO.getCoursesGroup(), CoursesgroupEntity.class);
            coursesgroupEntity.setId(courseTO.getCoursesGroup().getId());
            coursesgroupEntity.setName(courseTO.getCoursesGroup().getName());
            List<CourseEntity> courses = new ArrayList<>();
            for(CourseTO courseTOTMP : courseTO.getCoursesGroup().getCourses()) {
                CourseEntity courseTMP = mapper.map(courseTOTMP, CourseEntity.class);
                courseTMP.setId(courseTOTMP.getId());
                courseTMP.setName(courseTO.getName());
                courseTMP.setEcts(courseTO.getEcts());
                courseTMP.setTechnical(courseTO.getTechnical());
                courseTMP.setCode(courseTO.getCode());
                courseTMP.setZzuHours(courseTO.getZzuHours());
                ClassestypeEntity classestypeEntityTMP = mapper.map(courseTOTMP.getClassesType(), ClassestypeEntity.class);
                classestypeEntityTMP.setId(courseTOTMP.getClassesType().getId());
                classestypeEntityTMP.setName(courseTOTMP.getClassesType().getName());
                courseTMP.setClassesType(classestypeEntityTMP);
                CoursetypeEntity coursetypeEntityTMP = mapper.map(courseTOTMP.getCourseType(), CoursetypeEntity.class);
                coursetypeEntityTMP.setId(courseTOTMP.getCourseType().getId());
                coursetypeEntityTMP.setName(courseTOTMP.getCourseType().getName());
                courseTMP.setCourseType(coursetypeEntityTMP);
                CourseformEntity courseformEntityTMP = mapper.map(courseTOTMP.getCourseForm(), CourseformEntity.class);
                courseformEntityTMP.setId(courseTOTMP.getCourseForm().getId());
                courseformEntityTMP.setName(courseTOTMP.getCourseForm().getName());
                courseTMP.setForm(courseformEntityTMP);
                KindEntity kindEntityTMP = mapper.map(courseTOTMP.getKind(), KindEntity.class);
                kindEntityTMP.setId(courseTOTMP.getKind().getId());
                kindEntityTMP.setName(courseTOTMP.getKind().getName());
                courseTMP.setKind(kindEntityTMP);
                PassingwayEntity passingwayEntity = mapper.map(courseTOTMP.getPassingWay(), PassingwayEntity.class);
                passingwayEntity.setId(courseTOTMP.getPassingWay().getId());
                passingwayEntity.setName(courseTOTMP.getPassingWay().getName());
                courseTMP.setPassingWay(passingwayEntity);
                SubjectEntity subjectEntity = mapper.map(courseTOTMP.getSubject(), SubjectEntity.class);
                subjectEntity.setId(courseTOTMP.getSubject().getId());
                courseTMP.setSubject(subjectEntity);
                courses.add(courseTMP);
            }
            coursesgroupEntity.setCourses(courses);
        }
        courseEntity.setCoursesGroup(coursesgroupEntity);
        CourseformEntity courseformEntity = mapper.map(courseTO.getCourseForm(), CourseformEntity.class);
        courseformEntity.setId(courseTO.getCourseForm().getId());
        courseformEntity.setName(courseTO.getCourseForm().getName());
        courseEntity.setForm(courseformEntity);
        KindEntity kindEntity = mapper.map(courseTO.getKind(), KindEntity.class);
        kindEntity.setId(courseTO.getKind().getId());
        kindEntity.setName(courseTO.getKind().getName());
        courseEntity.setKind(kindEntity);
        PassingwayEntity passingwayEntity = mapper.map(courseTO.getPassingWay(), PassingwayEntity.class);
        passingwayEntity.setId(courseTO.getPassingWay().getId());
        passingwayEntity.setName(courseTO.getPassingWay().getName());
        courseEntity.setPassingWay(passingwayEntity);
        SubjectEntity subjectEntity = null;
        if (courseTO.getSubject()!= null) {
            subjectEntity = mapper.map(courseTO.getSubject(), SubjectEntity.class);
            subjectEntity.setId(courseTO.getSubject().getId());
        }
        courseEntity.setSubject(subjectEntity);
        return courseEntity;
    }

    public static CourseTO mapToTO(CourseEntity course) {
        int id = course.getId();
        String name = course.getName();
        int ects = course.getEcts();
        byte technical = course.getTechnical();
        String code = course.getCode();
        int zzuHours = course.getZzuHours();
        ClassesTypeTO classesTypeTO = new ClassesTypeTO(course.getClassesType().getId(), course.getClassesType().getName());
        CourseTypeTO courseTypeTO = new CourseTypeTO(course.getCourseType().getId(), course.getCourseType().getName());
        CoursesGroupTO coursesGroupTO = null;
        if(course.getCoursesGroup().getCourses() != null) {
            List<CourseTO> coursesGroups = new ArrayList<>();
            for(CourseEntity courseTMP: course.getCoursesGroup().getCourses()) {
                int idTMP = courseTMP.getId();
                String nameTMP = courseTMP.getName();
                int ectsTMP = courseTMP.getEcts();
                byte technicalTMP = courseTMP.getTechnical();
                String codeTMP = courseTMP.getCode();
                int zzuHoursTMP = courseTMP.getZzuHours();
                ClassesTypeTO classesTypeTOTMP = new ClassesTypeTO(courseTMP.getClassesType().getId(), courseTMP.getClassesType().getName());
                CourseTypeTO courseTypeTOTMP = new CourseTypeTO(courseTMP.getCourseType().getId(), courseTMP.getCourseType().getName());
                CourseFormTO courseFormTOTMP = new CourseFormTO(courseTMP.getForm().getId(), courseTMP.getForm().getName());
                KindTO kindTOTMP = new KindTO(courseTMP.getKind().getId(), courseTMP.getKind().getName());
                PassingWayTO passingWayTOTMP = new PassingWayTO(courseTMP.getPassingWay().getId(), courseTMP.getPassingWay().getName());
                SubjectTO subjectTOTMP = new SubjectTO(courseTMP.getSubject().getId());
                CourseTO courseTOTMP = new CourseTO(idTMP,nameTMP,ectsTMP,technicalTMP,codeTMP, zzuHoursTMP, classesTypeTOTMP, courseTypeTOTMP, null, courseFormTOTMP, kindTOTMP, passingWayTOTMP, subjectTOTMP);
                coursesGroups.add(courseTOTMP);
            }
            coursesGroupTO = new CoursesGroupTO(course.getCoursesGroup().getId(), course.getCoursesGroup().getName(), coursesGroups);
        }
        CourseFormTO courseFormTO = new CourseFormTO(course.getForm().getId(), course.getForm().getName());
        KindTO kindTO = new KindTO(course.getKind().getId(), course.getKind().getName());
        PassingWayTO passingWayTO = new PassingWayTO(course.getPassingWay().getId(), course.getPassingWay().getName());
        List<CourseEducationEffectTO> courseEducationEffectsTO = null;
        if (course.getSubject().getCourseEducationEffects() != null) {
            courseEducationEffectsTO = new ArrayList<>();
            for(CourseeducationeffectEntity courseeducationeffectEntity : course.getSubject().getCourseEducationEffects()) {
                CourseEducationEffectTO courseEducationEffectTO = new CourseEducationEffectTO(courseeducationeffectEntity.getSymbol(), courseeducationeffectEntity.getEducationEffect());
                courseEducationEffectsTO.add(courseEducationEffectTO);
            }
        }
        List<SubjectCardTO> subjectCardsTO = null;
        if(course.getSubject().getSubjectCards() != null) {
            subjectCardsTO = new ArrayList<>();
            for(SubjectcardEntity subjectcardEntity : course.getSubject().getSubjectCards()) {
                SubjectCardTO subjectCardTO = new SubjectCardTO(subjectcardEntity.getLink());
                subjectCardsTO.add(subjectCardTO);
            }
        }
        SubjectTO subjectTO = new SubjectTO(courseEducationEffectsTO, subjectCardsTO);
        CourseTO courseTO = new CourseTO(id, name, ects, technical, code, zzuHours, classesTypeTO, courseTypeTO, coursesGroupTO, courseFormTO, kindTO, passingWayTO, subjectTO);
        return courseTO;
    }
}
