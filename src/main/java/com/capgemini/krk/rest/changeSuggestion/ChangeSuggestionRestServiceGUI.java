package com.capgemini.krk.rest.changeSuggestion;

import com.capgemini.krk.TO.ChangeSuggestion.ChangeSuggestionTO;
import com.capgemini.krk.TO.ChangeSuggestion.ChangeSuggestionsTO;
import com.capgemini.krk.services.ChangeSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/gui")
public class ChangeSuggestionRestServiceGUI {

    @Autowired
    private ChangeSuggestionService changeSuggestionService;

    @RequestMapping(value = "/change-suggestions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ChangeSuggestionsTO findAll() {
        ChangeSuggestionsTO changeSuggestionsTO =  changeSuggestionService.findAll();
        return changeSuggestionsTO;
    }

    @RequestMapping(value = "/change-suggestions/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ChangeSuggestionTO findById(@PathVariable int id) {
        ChangeSuggestionTO changeSuggestionTO = changeSuggestionService.findById(id);
        return  changeSuggestionTO;
    }

    @RequestMapping(value = "/change-suggestions/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        changeSuggestionService.delete(id);
    }

    @RequestMapping(value = "/change-suggestions", method = RequestMethod.PUT)
    public void update(@RequestBody ChangeSuggestionTO changeSuggestionTO) {
        changeSuggestionService.updateChangeSuggestionProposition(changeSuggestionTO);
    }

}
