package com.capgemini.krk.rest.subjectCard;

import com.capgemini.krk.TO.subjectCard.SubjectCardTO;
import com.capgemini.krk.TO.subjectCard.SubjectCardsTO;
import com.capgemini.krk.services.subjectCard.SubjectCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/gui")
public class SubjectCardRestServiceGUI {

    @Autowired
    private SubjectCardService subjectCardService;

    @RequestMapping(value = "/subject-cards", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public SubjectCardsTO findAll() {
        SubjectCardsTO subjectCardsTO =  subjectCardService.findAll();
        return subjectCardsTO;
    }

    @RequestMapping(value = "/subject-cards-overview/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public SubjectCardsTO findByCourseId(@PathVariable int id) {
        SubjectCardsTO subjectCardsTO =  subjectCardService.findByCourseId(id);
        return subjectCardsTO;
    }

    @RequestMapping(value = "subject-cards/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public SubjectCardTO findById(@PathVariable int id) {
        SubjectCardTO subjectCardTO = subjectCardService.findById(id);
        return subjectCardTO;
    }

}
