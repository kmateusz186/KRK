package com.capgemini.krk.services.educationProgram;

import com.capgemini.krk.TO.educationProgram.EducationProgramTO;
import com.capgemini.krk.TO.educationProgram.EducationProgramsTO;
import com.capgemini.krk.entities.EducationprogramEntity;
import com.capgemini.krk.mappers.EducationProgramMapper;
import com.capgemini.krk.repositories.educationProgram.EducationProgramRepository;
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
    public void updateEducationProgramPeriod(EducationProgramTO educationProgram) {
        int modelId = educationProgram.getId();
        EducationprogramEntity educationProgramDb = educationProgramRepository.findById(modelId);

        String period = educationProgram.getPeriod();
        educationProgramDb.setPeriod(period);
    }
}
