package com.capgemini.krk.rest.educationProgram;

import com.capgemini.krk.TO.educationProgram.EducationProgramsTO;
import com.capgemini.krk.services.educationProgram.EducationProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class EducationProgramRestServiceAPI {

    @Autowired
    private EducationProgramService educationProgramService;

    @RequestMapping(value = "/education-programs/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveState(@PathVariable int id, @RequestBody EducationProgramsTO educationProgramsTO) {
        educationProgramService.saveState(id, educationProgramsTO);
    }

}
