package com.capgemini.krk.services.studiesPlan;

import com.capgemini.krk.TO.educationProgram.EducationProgramTO;
import com.capgemini.krk.TO.educationProgram.EducationProgramsTO;
import com.capgemini.krk.TO.semester.SemesterTO;
import com.capgemini.krk.TO.studiesPlan.StudiesPlanTO;
import com.capgemini.krk.TO.studiesPlan.StudiesPlansTO;
import com.capgemini.krk.entities.*;
import com.capgemini.krk.mappers.EducationProgramMapper;
import com.capgemini.krk.mappers.SemesterMapper;
import com.capgemini.krk.mappers.StudiesPlanMapper;
import com.capgemini.krk.repositories.Semester.SemesterRepository;
import com.capgemini.krk.repositories.educationLevel.EducationLevelRepository;
import com.capgemini.krk.repositories.educationProgram.EducationProgramRepository;
import com.capgemini.krk.repositories.faculty.FacultyRepository;
import com.capgemini.krk.repositories.mode.ModeRepository;
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
public class StudiesPlanServiceImpl implements StudiesPlanService {

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


    @Override
    @Transactional
    public void saveState(int id, StudiesPlansTO studiesPlansTO) {
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
    public StudiesPlansTO findAll() {
        List<StudiesplanEntity> studiesPlans = studiesPlanRepository.findAll();

        List<StudiesPlanTO> studiesPlanTOList = studiesPlans.stream()
                    .map(StudiesPlanMapper::mapToTO)
                    .collect(Collectors.toList());

        StudiesPlansTO studiesPlansTO = new StudiesPlansTO(studiesPlanTOList);

        return studiesPlansTO;
    }

    @Override
    public StudiesPlansTO findByEducationProgramId(int id) {
        List<StudiesplanEntity> studiesPlans = studiesPlanRepository.findByEducationProgramId(id);

        List<StudiesPlanTO> studiesPlanTOList = studiesPlans.stream()
                .map(StudiesPlanMapper::mapToTO)
                .collect(Collectors.toList());

        StudiesPlansTO studiesPlansTO = new StudiesPlansTO(studiesPlanTOList);

        return studiesPlansTO;
    }

    @Override
    public StudiesPlanTO findById(int id) {
        StudiesplanEntity studiesPlan = studiesPlanRepository.findById(id);
        StudiesPlanTO studiesPlanTO = StudiesPlanMapper.mapToTO(studiesPlan);
        return studiesPlanTO;
    }

    @Override
    @Transactional
    public void delete(int id) {
        studiesPlanRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateStudiesPlan(StudiesPlanTO studiesPlan) {
        /*int modelId = educationProgram.getId();
        EducationprogramEntity educationProgramDb = educationProgramRepository.findById(modelId);
        educationProgramDb.setPeriod(educationProgram.getPeriod());
        educationProgramDb.setCourse(educationProgram.getCourse());
        educationProgramDb.setSpecialization(educationProgram.getSpecialization());
        ModeEntity modeEntity = modeRepository.findByName(educationProgram.getMode().getName());
        if (modeEntity == null) {
            educationProgramDb.setMode(modeRepository.save(educationProgramDb.getMode()));
        } else {
            educationProgramDb.setMode(modeEntity);
        }
        ProfileEntity profileEntity = profileRepository.findByName(educationProgram.getProfile().getName());
        if (profileEntity == null) {
            educationProgramDb.setProfile(profileRepository.save(educationProgramDb.getProfile()));
        } else {
            educationProgramDb.setProfile(profileEntity);
        }
        EducationlevelEntity educationlevelEntity = educationLevelRepository.findByName(educationProgram.getLevel().getName());
        if (educationlevelEntity == null) {
            educationProgramDb.setLevel(educationLevelRepository.save(educationProgramDb.getLevel()));
        } else {
            educationProgramDb.setLevel(educationlevelEntity);
        }
        FacultyEntity facultyEntity = facultyRepository.findByName(educationProgram.getFaculty().getName());
        if (facultyEntity == null) {
            educationProgramDb.setFaculty(facultyRepository.save(educationProgramDb.getFaculty()));
        } else {
            educationProgramDb.setFaculty(facultyEntity);
        } */
    }

    @Override
    @Transactional
    public StudiesPlanTO insertStudiesPlan(StudiesPlanTO studiesPlan) {
        EducationprogramEntity educationprogramEntity = educationProgramRepository.findById(studiesPlan.getEducationProgram().getId());
        StudiesplanEntity studiesplanEntity = StudiesPlanMapper.mapToEntity(studiesPlan);
        studiesplanEntity.setEducationProgram(educationprogramEntity);
        studiesPlanRepository.save(studiesplanEntity);
        StudiesPlanTO insertedStudiesPlan = StudiesPlanMapper.mapToTO(studiesplanEntity);
        return insertedStudiesPlan;
    }
}
