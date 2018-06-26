package com.capgemini.krk.services.course;

import com.capgemini.krk.TO.course.CourseTO;
import com.capgemini.krk.TO.course.CoursesTO;
import com.capgemini.krk.TO.courseModule.CoursesModuleTO;
import com.capgemini.krk.entities.*;
import com.capgemini.krk.mappers.CourseMapper;
import com.capgemini.krk.repositories.Semester.SemesterRepository;
import com.capgemini.krk.repositories.classesType.ClassesTypeRepository;
import com.capgemini.krk.repositories.course.CourseRepository;
import com.capgemini.krk.repositories.courseForm.CourseFormRepository;
import com.capgemini.krk.repositories.courseType.CourseTypeRepository;
import com.capgemini.krk.repositories.coursesGroup.CoursesGroupRepository;
import com.capgemini.krk.repositories.coursesModules.CoursesModuleRepository;
import com.capgemini.krk.repositories.educationLevel.EducationLevelRepository;
import com.capgemini.krk.repositories.educationProgram.EducationProgramRepository;
import com.capgemini.krk.repositories.faculty.FacultyRepository;
import com.capgemini.krk.repositories.kind.KindRepository;
import com.capgemini.krk.repositories.mode.ModeRepository;
import com.capgemini.krk.repositories.moduleType.ModuleTypeRepository;
import com.capgemini.krk.repositories.passingWay.PassingWayRepository;
import com.capgemini.krk.repositories.profile.ProfileRepository;
import com.capgemini.krk.repositories.studiesPlan.StudiesPlanRepository;
import com.capgemini.krk.repositories.subject.SubjectRepository;
import com.capgemini.krk.services.coursesModule.CoursesModuleServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CoursesModuleRepository coursesModuleRepository;

    @Autowired
    private ModuleTypeRepository moduleTypeRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseTypeRepository courseTypeRepository;

    @Autowired
    private ClassesTypeRepository classesTypeRepository;

    @Autowired
    private CourseFormRepository courseFormRepository;

    @Autowired
    private PassingWayRepository passingWayRepository;

    @Autowired
    private KindRepository kindRepository;

    @Autowired
    private CoursesGroupRepository coursesGroupRepository;

    @Autowired
    private SubjectRepository subjectRepository;


    @Override
    public CoursesTO findAll() {
        List<CourseEntity> courses = courseRepository.findAll();

        List<CourseTO> courseTOList = courses.stream()
                    .map(CourseMapper::mapToTO)
                    .collect(Collectors.toList());

        CoursesTO coursesTO = new CoursesTO(courseTOList);

        return coursesTO;
    }

    @Override
    public CoursesTO findByCoursesModuleId(int id) {
        CoursesmoduleEntity coursesmoduleEntity = coursesModuleRepository.findById(id);
        List<CourseEntity> courses = coursesmoduleEntity.getCourses();

        List<CourseTO> courseTOList = courses.stream()
                .map(CourseMapper::mapToTO)
                .collect(Collectors.toList());

        CoursesTO coursesTO = new CoursesTO(courseTOList);

        return coursesTO;
    }

    @Override
    public CourseTO findById(int id) {
        CourseEntity course = courseRepository.findById(id);
        CourseTO courseTO = CourseMapper.mapToTO(course);
        return courseTO;
    }

    @Override
    @Transactional
    public void delete(int id) {
        CourseEntity courseEntity = courseRepository.findById(id);
        courseEntity.getCoursesModules().clear();
        courseRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateCourse(CourseTO course) {
        int id = course.getId();
        CourseEntity courseEntity = courseRepository.findById(id);
        courseEntity.setName(course.getName());
        courseEntity.setEcts(course.getEcts());
        courseEntity.setTechnical(course.getTechnical());
        courseEntity.setCode(course.getCode());
        CoursetypeEntity coursetypeEntity = courseTypeRepository.findByName(course.getCourseType().getName());
        if (coursetypeEntity == null) {
            courseEntity.setCourseType(courseTypeRepository.save(courseEntity.getCourseType()));
        } else {
            courseEntity.setCourseType(coursetypeEntity);
        }
        ClassestypeEntity classestypeEntity = classesTypeRepository.findByName(course.getClassesType().getName());
        if (classestypeEntity == null) {
            courseEntity.setClassesType(classesTypeRepository.save(courseEntity.getClassesType()));
        } else {
            courseEntity.setClassesType(classestypeEntity);
        }
        CourseformEntity courseformEntity = courseFormRepository.findByName(course.getCourseForm().getName());
        if (courseformEntity == null) {
            courseEntity.setForm(courseFormRepository.save(courseEntity.getForm()));
        } else {
            courseEntity.setForm(courseformEntity);
        }
        PassingwayEntity passingwayEntity = passingWayRepository.findByName(course.getPassingWay().getName());
        if (passingwayEntity == null) {
            courseEntity.setPassingWay(passingWayRepository.save(courseEntity.getPassingWay()));
        } else {
            courseEntity.setPassingWay(passingwayEntity);
        }
        CoursesgroupEntity coursesgroupEntity = coursesGroupRepository.findByName(course.getCoursesGroup().getName());
        if (coursesgroupEntity == null) {
            courseEntity.setCoursesGroup(coursesGroupRepository.save(courseEntity.getCoursesGroup()));
        } else {
            courseEntity.setCoursesGroup(coursesgroupEntity);
        }
    }

    @Override
    @Transactional
    public CourseTO insertCourse(int coursesModuleId, CourseTO course) {
        CourseEntity courseEntity = CourseMapper.mapToEntity(course);
        courseEntity.setName(course.getName());
        courseEntity.setEcts(course.getEcts());
        courseEntity.setTechnical(course.getTechnical());
        courseEntity.setCode(course.getCode());
        CoursetypeEntity coursetypeEntity = courseTypeRepository.findByName(course.getCourseType().getName());
        if (coursetypeEntity == null) {
            courseEntity.setCourseType(courseTypeRepository.save(courseEntity.getCourseType()));
        } else {
            courseEntity.setCourseType(coursetypeEntity);
        }
        ClassestypeEntity classestypeEntity = classesTypeRepository.findByName(course.getClassesType().getName());
        if (classestypeEntity == null) {
            courseEntity.setClassesType(classesTypeRepository.save(courseEntity.getClassesType()));
        } else {
            courseEntity.setClassesType(classestypeEntity);
        }
        CourseformEntity courseformEntity = courseFormRepository.findByName(course.getCourseForm().getName());
        if (courseformEntity == null) {
            courseEntity.setForm(courseFormRepository.save(courseEntity.getForm()));
        } else {
            courseEntity.setForm(courseformEntity);
        }
        PassingwayEntity passingwayEntity = passingWayRepository.findByName(course.getPassingWay().getName());
        if (passingwayEntity == null) {
            courseEntity.setPassingWay(passingWayRepository.save(courseEntity.getPassingWay()));
        } else {
            courseEntity.setPassingWay(passingwayEntity);
        }
        KindEntity kindEntity = kindRepository.findByName(course.getKind().getName());
        if (kindEntity == null) {
            courseEntity.setKind(kindRepository.save(courseEntity.getKind()));
        } else {
            courseEntity.setKind(kindEntity);
        }
        CoursesgroupEntity coursesgroupEntity = coursesGroupRepository.findByName(course.getCoursesGroup().getName());
        if (coursesgroupEntity == null) {
            courseEntity.setCoursesGroup(coursesGroupRepository.save(courseEntity.getCoursesGroup()));
        } else {
            courseEntity.setCoursesGroup(coursesgroupEntity);
        }
        courseEntity.setSubject(subjectRepository.findByNamePl(course.getSubject().getNamePL()));
        courseRepository.save(courseEntity);
        CourseTO insertedCourse = CourseMapper.mapToTO(courseEntity);
        CoursesmoduleEntity coursesmoduleEntity = coursesModuleRepository.findById(coursesModuleId);
        coursesmoduleEntity.getCourses().add(courseEntity);
        return insertedCourse;
    }
}
