package com.capgemini.krk.repositories.Semester;

import com.capgemini.krk.entities.SemesterEntity;
import com.capgemini.krk.entities.StudiesplanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SemesterRepository extends JpaRepository<SemesterEntity, Integer> {

    SemesterEntity findById(int id);

    List<SemesterEntity> findAll();

    void deleteById(int id);
}
