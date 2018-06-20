package com.capgemini.krk.repositories.educationProgram;

import com.capgemini.krk.entities.EducationprogramEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationProgramRepository extends JpaRepository<EducationprogramEntity, Integer> {

    EducationprogramEntity findById(int id);

    List<EducationprogramEntity> findAll();

    void deleteById(int id);
}
