package com.capgemini.krk.rest.studiesPlan;

import com.capgemini.krk.TO.studiesPlan.StudiesPlanTO;
import com.capgemini.krk.TO.studiesPlan.StudiesPlansTO;
import com.capgemini.krk.services.studiesPlan.StudiesPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/gui")
public class StudiesPlanRestServiceGUI {

    @Autowired
    private StudiesPlanService studiesPlanService;

    @RequestMapping(value = "/studies-plans", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public StudiesPlansTO findAll() {
        StudiesPlansTO studiesPlansTO =  studiesPlanService.findAll();
        return studiesPlansTO;
    }

    @RequestMapping(value = "/studies-plans-overview/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public StudiesPlansTO findByEducationProgramId(@PathVariable int id) {
        StudiesPlansTO studiesPlansTO =  studiesPlanService.findByEducationProgramId(id);
        return studiesPlansTO;
    }

    @RequestMapping(value = "/studies-plans/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public StudiesPlanTO findById(@PathVariable int id) {
        StudiesPlanTO studiesPlanTO = studiesPlanService.findById(id);
        return studiesPlanTO;
    }

    @RequestMapping(value = "/studies-plans/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        studiesPlanService.delete(id);
    }


    @RequestMapping(value = "/studies-plans-up", method = RequestMethod.PUT)
    public void update(@RequestBody StudiesPlanTO studiesPlanTO) {
        studiesPlanService.updateStudiesPlan(studiesPlanTO);
    }

    @RequestMapping(value = "/studies-plans-in", method = RequestMethod.PUT)
    public void insert(@RequestBody StudiesPlanTO studiesPlanTO) {
        studiesPlanService.insertStudiesPlan(studiesPlanTO);
    }

}
