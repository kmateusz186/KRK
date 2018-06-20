package com.capgemini.krk.rest.changeSuggestion;

import com.capgemini.krk.TO.changeSuggestion.ChangeSuggestionTO;
import com.capgemini.krk.TO.changeSuggestion.ChangeSuggestionsTO;
import com.capgemini.krk.services.changeSuggestion.ChangeSuggestionService;
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

    @RequestMapping(value = "/change-suggestions-ef", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ChangeSuggestionsTO findByEducationProgramIsNull() {
        ChangeSuggestionsTO changeSuggestionsTO =  changeSuggestionService.findByEducationProgramIsNull();
        return changeSuggestionsTO;
    }

    @RequestMapping(value = "/change-suggestions-ep", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ChangeSuggestionsTO findByEducationEffectIsNull() {
        ChangeSuggestionsTO changeSuggestionsTO =  changeSuggestionService.findByEducationEffectIsNull();
        return changeSuggestionsTO;
    }

    @RequestMapping(value = "/change-suggestions/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ChangeSuggestionTO findById(@PathVariable int id) {
        ChangeSuggestionTO changeSuggestionTO = changeSuggestionService.findById(id);
        return  changeSuggestionTO;
    }

    @RequestMapping(value = "/change-suggestions-ep/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ChangeSuggestionTO findByEpId(@PathVariable int id) {
        ChangeSuggestionTO changeSuggestionTO = changeSuggestionService.findById(id);
        return  changeSuggestionTO;
    }

    @RequestMapping(value = "/change-suggestions-ef/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ChangeSuggestionTO findByEfId(@PathVariable int id) {
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
