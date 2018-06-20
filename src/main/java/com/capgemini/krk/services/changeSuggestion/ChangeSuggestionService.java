package com.capgemini.krk.services.changeSuggestion;

import com.capgemini.krk.TO.changeSuggestion.ChangeSuggestionTO;
import com.capgemini.krk.TO.changeSuggestion.ChangeSuggestionsTO;

public interface ChangeSuggestionService {

    void saveState(int id, ChangeSuggestionsTO changeSuggestionsTO);

    ChangeSuggestionsTO findAll();

    ChangeSuggestionsTO findByEducationProgramIsNull();

    ChangeSuggestionsTO findByEducationEffectIsNull();

    ChangeSuggestionTO findById(int id);

    void delete(int id);

    void updateChangeSuggestionProposition(ChangeSuggestionTO changeSuggestion);

}
