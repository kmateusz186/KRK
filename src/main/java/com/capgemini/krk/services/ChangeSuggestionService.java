package com.capgemini.krk.services;

import com.capgemini.krk.TO.ChangeSuggestion.ChangeSuggestionTO;
import com.capgemini.krk.TO.ChangeSuggestion.ChangeSuggestionsTO;

public interface ChangeSuggestionService {

    void saveState(int id, ChangeSuggestionsTO changeSuggestionsTO);

    ChangeSuggestionsTO findAll();

    ChangeSuggestionTO findById(int id);

    void delete(int id);

    void updateChangeSuggestionProposition(ChangeSuggestionTO changeSuggestion);

}
