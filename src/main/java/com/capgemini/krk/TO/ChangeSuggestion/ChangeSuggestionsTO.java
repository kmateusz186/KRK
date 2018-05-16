package com.capgemini.krk.TO.ChangeSuggestion;

import lombok.*;

import java.util.List;

public class ChangeSuggestionsTO {

    private List<ChangeSuggestionTO> changeSuggestions;

    public ChangeSuggestionsTO(List<ChangeSuggestionTO> changeSuggestions) {
        this.changeSuggestions = changeSuggestions;
    }

    public ChangeSuggestionsTO() {
    }
}