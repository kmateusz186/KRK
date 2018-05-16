package com.capgemini.krk.rest.changeSuggestion;

import com.capgemini.krk.TO.ChangeSuggestion.ChangeSuggestionsTO;
import com.capgemini.krk.services.ChangeSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ChangeSuggestionRestServiceAPI {

    @Autowired
    private ChangeSuggestionService changeSuggestionService;

    @RequestMapping(value = "/change-suggestions/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveState(@PathVariable int id, @RequestBody ChangeSuggestionsTO changeSuggestionsTO) {
        changeSuggestionService.saveState(id, changeSuggestionsTO);
    }

}
