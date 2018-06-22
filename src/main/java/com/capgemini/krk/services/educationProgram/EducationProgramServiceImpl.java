package com.capgemini.krk.services.educationProgram;

import com.capgemini.krk.TO.educationLevel.EducationLevelTO;
import com.capgemini.krk.TO.educationProgram.EducationProgramTO;
import com.capgemini.krk.TO.educationProgram.EducationProgramsTO;
import com.capgemini.krk.TO.faculty.FacultyTO;
import com.capgemini.krk.TO.mode.ModeTO;
import com.capgemini.krk.TO.profile.ProfileTO;
import com.capgemini.krk.entities.*;
;
import com.capgemini.krk.mappers.EducationProgramMapper;
import com.capgemini.krk.repositories.educationLevel.EducationLevelRepository;
import com.capgemini.krk.repositories.educationProgram.EducationProgramRepository;
import com.capgemini.krk.repositories.faculty.FacultyRepository;
import com.capgemini.krk.repositories.mode.ModeRepository;
import com.capgemini.krk.repositories.profile.ProfileRepository;
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
public class EducationProgramServiceImpl implements EducationProgramService {

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


    @Override
    @Transactional
    public void saveState(int id, EducationProgramsTO educationProgramsTO) {
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
    public EducationProgramsTO findAll() {
        List<EducationprogramEntity> educationPrograms = educationProgramRepository.findAll();

        List<EducationProgramTO> educationProgramTOList = educationPrograms.stream()
                    .map(EducationProgramMapper::mapToTO)
                    .collect(Collectors.toList());

        EducationProgramsTO educationProgramsTO = new EducationProgramsTO(educationProgramTOList);

        return educationProgramsTO;
    }

    @Override
    public EducationProgramTO findById(int id) {
        EducationprogramEntity educationProgram = educationProgramRepository.findById(id);
        EducationProgramTO educationProgramTO = EducationProgramMapper.mapToTO(educationProgram);
        return educationProgramTO;
    }

    @Override
    @Transactional
    public void delete(int id) {
        educationProgramRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateEducationProgram(EducationProgramTO educationProgram) {
        int modelId = educationProgram.getId();
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
        }
    }

    @Override
    @Transactional
    public EducationProgramTO insertEducationProgram(EducationProgramTO educationProgram) {

        EducationprogramEntity educationprogramEntity = EducationProgramMapper.mapToEntity(educationProgram);
        ModeEntity modeEntity = modeRepository.findByName(educationProgram.getMode().getName());
        if (modeEntity == null) {
            educationprogramEntity.setMode(modeRepository.save(educationprogramEntity.getMode()));
        } else {
            educationprogramEntity.setMode(modeEntity);
        }
        ProfileEntity profileEntity = profileRepository.findByName(educationProgram.getProfile().getName());
        if (profileEntity == null) {
            educationprogramEntity.setProfile(profileRepository.save(educationprogramEntity.getProfile()));
        } else {
            educationprogramEntity.setProfile(profileEntity);
        }
        EducationlevelEntity educationlevelEntity = educationLevelRepository.findByName(educationProgram.getLevel().getName());
        if (educationlevelEntity == null) {
            educationprogramEntity.setLevel(educationLevelRepository.save(educationprogramEntity.getLevel()));
        } else {
            educationprogramEntity.setLevel(educationlevelEntity);
        }
        FacultyEntity facultyEntity = facultyRepository.findByName(educationProgram.getFaculty().getName());
        if (facultyEntity == null) {
            educationprogramEntity.setFaculty(facultyRepository.save(educationprogramEntity.getFaculty()));
        } else {
            educationprogramEntity.setFaculty(facultyEntity);
        }
        educationProgramRepository.save(educationprogramEntity);
        EducationProgramTO insertedEducationProgram = EducationProgramMapper.mapToTO(educationprogramEntity);
        return insertedEducationProgram;
    }
}
