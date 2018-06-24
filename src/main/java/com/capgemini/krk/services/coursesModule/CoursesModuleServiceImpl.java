package com.capgemini.krk.services.coursesModule;

import com.capgemini.krk.TO.courseModule.CoursesModuleTO;
import com.capgemini.krk.TO.courseModule.CoursesModulesTO;
import com.capgemini.krk.TO.studiesPlan.StudiesPlanTO;
import com.capgemini.krk.TO.studiesPlan.StudiesPlansTO;
import com.capgemini.krk.entities.*;
import com.capgemini.krk.mappers.CoursesModuleMapper;
import com.capgemini.krk.mappers.StudiesPlanMapper;
import com.capgemini.krk.repositories.Semester.SemesterRepository;
import com.capgemini.krk.repositories.coursesModules.CoursesModuleRepository;
import com.capgemini.krk.repositories.educationLevel.EducationLevelRepository;
import com.capgemini.krk.repositories.educationProgram.EducationProgramRepository;
import com.capgemini.krk.repositories.faculty.FacultyRepository;
import com.capgemini.krk.repositories.mode.ModeRepository;
import com.capgemini.krk.repositories.moduleType.ModuleTypeRepository;
import com.capgemini.krk.repositories.profile.ProfileRepository;
import com.capgemini.krk.repositories.studiesPlan.StudiesPlanRepository;
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
public class CoursesModuleServiceImpl implements CoursesModuleService {

    @Autowired
    private EducationProgramRepository educationProgramRepository;

    @Autowired
    private EducationLevelRepository educationLevelRepository;

    @Autowired
    private ModeRepository modeRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private StudiesPlanRepository studiesPlanRepository;

    @Autowired
    private SemesterRepository semesterRepository;

    @Autowired
    private CoursesModuleRepository coursesModuleRepository;

    @Autowired
    private ModuleTypeRepository moduleTypeRepository;


    @Override
    @Transactional
    public void saveState(int id, CoursesModuleTO coursesModule) {
        /*List<ControlPoint> controlPoints = controlPointsTO.getControlPoints().stream()
                .map(to -> ControlPointMapper.mapToEntity(to))
                .collect(Collectors.toList());

        for (ControlPoint cp : controlPoints) {
            ControlPoint dbControlPoint = controlPointRepository.findByModelId(cp.getModelId());
            if(dbControlPoint != null) {
                dbControlPoint.getStates().addAll(cp.getStates());
            } else {
                Account account = accountRepository.findOne(id);
                account.getControlPointList().add(cp);
            }
        } */
    }

    @Override
    public CoursesModulesTO findAll() {
        List<CoursesmoduleEntity> studiesPlans = coursesModuleRepository.findAll();

        List<CoursesModuleTO> coursesModuleTOList = studiesPlans.stream()
                    .map(CoursesModuleMapper::mapToTO)
                    .collect(Collectors.toList());

        CoursesModulesTO coursesModulesTO = new CoursesModulesTO(coursesModuleTOList);

        return coursesModulesTO;
    }

    @Override
    public CoursesModulesTO findBySemesterId(int id) {
        SemesterEntity semesterEntity = semesterRepository.findById(id);
        List<CoursesmoduleEntity> studiesPlans = semesterEntity.getCoursesModules();

        List<CoursesModuleTO> coursesModuleTOList = studiesPlans.stream()
                .map(CoursesModuleMapper::mapToTO)
                .collect(Collectors.toList());

        CoursesModulesTO coursesModulesTO = new CoursesModulesTO(coursesModuleTOList);

        return coursesModulesTO;
    }

    @Override
    public CoursesModulesTO findByOvModuleId(int id) {
        List<CoursesmoduleEntity> studiesPlans = coursesModuleRepository.findByOvModuleId(id);

        List<CoursesModuleTO> coursesModuleTOList = studiesPlans.stream()
                .map(CoursesModuleMapper::mapToTO)
                .collect(Collectors.toList());

        CoursesModulesTO coursesModulesTO = new CoursesModulesTO(coursesModuleTOList);

        return coursesModulesTO;
    }

    @Override
    public CoursesModuleTO findById(int id) {
        CoursesmoduleEntity coursesModule = coursesModuleRepository.findById(id);
        CoursesModuleTO coursesModuleTO = CoursesModuleMapper.mapToTO(coursesModule);
        return coursesModuleTO;
    }

    @Override
    @Transactional
    public void delete(int id) {
        coursesModuleRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateCoursesModule(CoursesModuleTO coursesModule) {
        int id = coursesModule.getId();
        CoursesmoduleEntity coursesmoduleEntity = coursesModuleRepository.findById(id);
        ModuletypeEntity moduletypeEntity = moduleTypeRepository.findByName(coursesModule.getModuleType().getName());
        if (moduletypeEntity == null) {
            coursesmoduleEntity.setModuleType(moduleTypeRepository.save(coursesmoduleEntity.getModuleType()));
        } else {
            coursesmoduleEntity.setModuleType(moduletypeEntity);
        }
        CoursesmoduleEntity coursesmoduleEntityOv = coursesModuleRepository.findByModuleTypeName(coursesModule.getOvModule().getModuleType().getName());
        if (coursesmoduleEntityOv == null) {
            coursesmoduleEntity.setOvModule(coursesModuleRepository.save(coursesmoduleEntity.getOvModule()));
        } else {
            coursesmoduleEntity.setOvModule(coursesmoduleEntityOv);
        }
    }

    @Override
    @Transactional
    public CoursesModuleTO insertCoursesModuleOv(CoursesModuleTO coursesModule) {
        CoursesmoduleEntity coursesmoduleEntity = CoursesModuleMapper.mapToEntity(coursesModule);
        ModuletypeEntity moduletypeEntity = moduleTypeRepository.findByName(coursesModule.getModuleType().getName());
        if (moduletypeEntity == null) {
            coursesmoduleEntity.setModuleType(moduleTypeRepository.save(coursesmoduleEntity.getModuleType()));
        } else {
            coursesmoduleEntity.setModuleType(moduletypeEntity);
        }
        CoursesmoduleEntity coursesmoduleEntityOv = null;
        if(coursesModule.getOvModule() != null) {
            coursesmoduleEntityOv = coursesModuleRepository.findByModuleTypeName(coursesModule.getOvModule().getModuleType().getName());
            if (coursesmoduleEntityOv == null) {
                coursesmoduleEntity.setOvModule(coursesModuleRepository.save(coursesmoduleEntity.getOvModule()));
            } else {
                coursesmoduleEntity.setOvModule(coursesmoduleEntityOv);
            }
        }
        coursesmoduleEntity.setOvModule(coursesmoduleEntityOv);
        coursesModuleRepository.save(coursesmoduleEntity);
        CoursesModuleTO insertedCoursesModule = CoursesModuleMapper.mapToTO(coursesmoduleEntity);
        return insertedCoursesModule;
    }

    @Override
    @Transactional
    public CoursesModuleTO insertCoursesModule(int semesterId, CoursesModuleTO coursesModule) {
        CoursesmoduleEntity coursesmoduleEntity = CoursesModuleMapper.mapToEntity(coursesModule);
        ModuletypeEntity moduletypeEntity = moduleTypeRepository.findByName(coursesModule.getModuleType().getName());
        if (moduletypeEntity == null) {
            coursesmoduleEntity.setModuleType(moduleTypeRepository.save(coursesmoduleEntity.getModuleType()));
        } else {
            coursesmoduleEntity.setModuleType(moduletypeEntity);
        }
        CoursesmoduleEntity coursesmoduleEntityOv = null;
        if(coursesModule.getOvModule()!= null) {
            coursesmoduleEntityOv = coursesModuleRepository.findByModuleTypeName(coursesModule.getOvModule().getModuleType().getName());
            if (coursesmoduleEntityOv == null) {
                coursesmoduleEntity.setOvModule(coursesModuleRepository.save(coursesmoduleEntity.getOvModule()));
            } else {
                coursesmoduleEntity.setOvModule(coursesmoduleEntityOv);
            }
        }
        coursesmoduleEntity.setOvModule(coursesmoduleEntityOv);
        coursesModuleRepository.save(coursesmoduleEntity);
        CoursesModuleTO insertedCoursesModule = CoursesModuleMapper.mapToTO(coursesmoduleEntity);
        SemesterEntity semesterEntity = semesterRepository.findById(semesterId);
        semesterEntity.getCoursesModules().add(coursesmoduleEntity);
        return insertedCoursesModule;
    }
}
