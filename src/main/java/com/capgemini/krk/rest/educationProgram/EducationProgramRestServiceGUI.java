package com.capgemini.krk.rest.educationProgram;

import com.capgemini.krk.TO.educationProgram.EducationProgramTO;
import com.capgemini.krk.TO.educationProgram.EducationProgramsTO;
import com.capgemini.krk.services.educationProgram.EducationProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/gui")
public class EducationProgramRestServiceGUI {

    @Autowired
    private EducationProgramService educationProgramService;

    @RequestMapping(value = "/education-programs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public EducationProgramsTO findAll() {
        EducationProgramsTO educationProgramsTO =  educationProgramService.findAll();
        return educationProgramsTO;
    }

    @RequestMapping(value = "/education-programs/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public EducationProgramTO findById(@PathVariable int id) {
        EducationProgramTO educationProgramTO = educationProgramService.findById(id);
        return educationProgramTO;
    }

    @RequestMapping(value = "/education-programs/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        educationProgramService.delete(id);
    }

    @RequestMapping(value = "/education-programs", method = RequestMethod.PUT)
    public void update(@RequestBody EducationProgramTO educationProgramTO) {
        educationProgramService.updateEducationProgramPeriod(educationProgramTO);
    }

}
