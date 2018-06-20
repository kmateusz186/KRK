package com.capgemini.krk.services.changeSuggestion;

import com.capgemini.krk.TO.changeSuggestion.ChangeSuggestionTO;
import com.capgemini.krk.TO.changeSuggestion.ChangeSuggestionsTO;
import com.capgemini.krk.entities.ChangesuggestionEntity;
import com.capgemini.krk.mappers.ChangeSuggestionMapper;
import com.capgemini.krk.repositories.changeSuggestion.ChangeSuggestionRepository;
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
public class ChangeSuggestionServiceImpl implements ChangeSuggestionService {

    @Autowired
    private ChangeSuggestionRepository changeSuggestionRepository;


    @Override
    @Transactional
    public void saveState(int id, ChangeSuggestionsTO changeSuggestionsTO) {
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
    public ChangeSuggestionsTO findAll() {
        List<ChangesuggestionEntity> changeSuggestions = changeSuggestionRepository.findAll();

        List<ChangeSuggestionTO> changeSuggestionTOList = changeSuggestions.stream()
                    .map(ChangeSuggestionMapper::mapToTO)
                    .collect(Collectors.toList());

        ChangeSuggestionsTO changeSuggestionsTO = new ChangeSuggestionsTO(changeSuggestionTOList);

        return changeSuggestionsTO;
    }

    @Override
    public ChangeSuggestionsTO findByEducationProgramIsNull() {
        List<ChangesuggestionEntity> changeSuggestions = changeSuggestionRepository.findAll();

        List<ChangeSuggestionTO> changeSuggestionTOList = changeSuggestions.stream()
                .map(ChangeSuggestionMapper::mapToTO)
                .collect(Collectors.toList());

        ChangeSuggestionsTO changeSuggestionsTO = new ChangeSuggestionsTO(changeSuggestionTOList);

        return changeSuggestionsTO;
    }

    @Override
    public ChangeSuggestionsTO findByEducationEffectIsNull() {
        List<ChangesuggestionEntity> changeSuggestions = changeSuggestionRepository.findAll();

        List<ChangeSuggestionTO> changeSuggestionTOList = changeSuggestions.stream()
                .map(ChangeSuggestionMapper::mapToTO)
                .collect(Collectors.toList());

        ChangeSuggestionsTO changeSuggestionsTO = new ChangeSuggestionsTO(changeSuggestionTOList);

        return changeSuggestionsTO;
    }

    @Override
    public ChangeSuggestionTO findById(int id) {
        ChangesuggestionEntity changeSuggestion = changeSuggestionRepository.findById(id);
        ChangeSuggestionTO changeSuggestionTO = ChangeSuggestionMapper.mapToTO(changeSuggestion);
        return changeSuggestionTO;
    }

    @Override
    @Transactional
    public void delete(int id) {
        changeSuggestionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateChangeSuggestionProposition(ChangeSuggestionTO changeSuggestion) {
        int modelId = changeSuggestion.getId();
        ChangesuggestionEntity changeSuggestionDb = changeSuggestionRepository.findById(modelId);

        String proposition = changeSuggestion.getProposition();
        changeSuggestionDb.setProposition(proposition);
    }


}
