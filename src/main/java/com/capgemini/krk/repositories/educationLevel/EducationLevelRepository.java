package com.capgemini.krk.repositories.educationLevel;

import com.capgemini.krk.entities.EducationlevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationLevelRepository extends JpaRepository<EducationlevelEntity, Integer> {

    EducationlevelEntity findByName(String name);

    List<EducationlevelEntity> findAll();

    void deleteById(int id);
}
