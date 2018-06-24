package com.capgemini.krk.mappers;

import com.capgemini.krk.TO.courseModule.CoursesModuleTO;
import com.capgemini.krk.TO.moduleType.ModuleTypeTO;
import com.capgemini.krk.entities.CoursesmoduleEntity;
import com.capgemini.krk.entities.ModuletypeEntity;
import org.modelmapper.ModelMapper;


public class CoursesModuleMapper {

    private static ModelMapper mapper = new ModelMapper();

    public static CoursesmoduleEntity mapToEntity(CoursesModuleTO coursesModuleTO) {

        CoursesmoduleEntity coursesmoduleEntity = mapper.map(coursesModuleTO, CoursesmoduleEntity.class);
        coursesmoduleEntity.setId(coursesModuleTO.getId());
        ModuletypeEntity moduletypeEntity = mapper.map(coursesModuleTO.getModuleType(), ModuletypeEntity.class);
        moduletypeEntity.setId(coursesModuleTO.getModuleType().getId());
        moduletypeEntity.setName(coursesModuleTO.getModuleType().getName());
        coursesmoduleEntity.setModuleType(moduletypeEntity);
        CoursesmoduleEntity coursesmoduleEntityOv = null;
        if(coursesModuleTO.getOvModule() != null) {
            coursesmoduleEntityOv = mapper.map(coursesModuleTO.getOvModule(), CoursesmoduleEntity.class);
            coursesmoduleEntityOv.setId(coursesModuleTO.getOvModule().getId());
            ModuletypeEntity moduletypeEntityOv = mapper.map(coursesModuleTO.getModuleType(), ModuletypeEntity.class);
            moduletypeEntityOv.setName(coursesModuleTO.getModuleType().getName());
            coursesmoduleEntityOv.setModuleType(moduletypeEntity);
        }
        coursesmoduleEntity.setOvModule(coursesmoduleEntityOv);
        return coursesmoduleEntity;
    }

    public static CoursesModuleTO mapToTO(CoursesmoduleEntity coursesmoduleEntity) {
        int id = coursesmoduleEntity.getId();
        ModuleTypeTO moduleTypeTO = new ModuleTypeTO(coursesmoduleEntity.getModuleType().getId(), coursesmoduleEntity.getModuleType().getName());
        CoursesModuleTO coursesModuleTOOv = null;
        if(coursesmoduleEntity.getOvModule() != null) {
            ModuleTypeTO moduleTypeTOOv = new ModuleTypeTO(coursesmoduleEntity.getOvModule().getModuleType().getId(), coursesmoduleEntity.getOvModule().getModuleType().getName());
            coursesModuleTOOv = new CoursesModuleTO(coursesmoduleEntity.getOvModule().getId(), moduleTypeTOOv, null, null);
        }
        CoursesModuleTO coursesModuleTO = new CoursesModuleTO(id, moduleTypeTO, coursesModuleTOOv, null);
        return coursesModuleTO;
    }
}
