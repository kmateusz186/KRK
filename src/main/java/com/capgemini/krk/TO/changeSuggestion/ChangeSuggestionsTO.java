package com.capgemini.krk.TO.changeSuggestion;

import java.util.List;

public class ChangeSuggestionsTO {

    private List<ChangeSuggestionTO> changeSuggestions;

    public ChangeSuggestionsTO(List<ChangeSuggestionTO> changeSuggestions) {
        this.changeSuggestions = changeSuggestions;
    }

    public ChangeSuggestionsTO() {
    }

    public List<ChangeSuggestionTO> getChangeSuggestions() {
        return changeSuggestions;
    }

    public void setChangeSuggestions(List<ChangeSuggestionTO> changeSuggestions) {
        this.changeSuggestions = changeSuggestions;
    }
}