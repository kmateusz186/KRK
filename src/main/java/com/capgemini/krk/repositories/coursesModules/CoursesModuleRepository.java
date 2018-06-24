package com.capgemini.krk.repositories.coursesModules;

import com.capgemini.krk.entities.CoursesmoduleEntity;
import com.capgemini.krk.entities.StudiesplanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursesModuleRepository extends JpaRepository<CoursesmoduleEntity, Integer> {

    CoursesmoduleEntity findById(int id);

    List<CoursesmoduleEntity> findByOvModuleId(int id);

    CoursesmoduleEntity findByModuleTypeName(String name);

    List<CoursesmoduleEntity> findAll();

    void deleteById(int id);
}
