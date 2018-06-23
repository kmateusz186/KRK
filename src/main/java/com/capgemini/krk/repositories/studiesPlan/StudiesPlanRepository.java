package com.capgemini.krk.repositories.studiesPlan;

import com.capgemini.krk.entities.StudiesplanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudiesPlanRepository extends JpaRepository<StudiesplanEntity, Integer> {

    StudiesplanEntity findById(int id);

    List<StudiesplanEntity> findAll();

    List<StudiesplanEntity> findByEducationProgramId(int id);

    void deleteById(int id);
}
