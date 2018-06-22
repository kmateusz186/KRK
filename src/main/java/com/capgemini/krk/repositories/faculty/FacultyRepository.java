package com.capgemini.krk.repositories.faculty;

import com.capgemini.krk.entities.FacultyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepository extends JpaRepository<FacultyEntity, Integer> {

    FacultyEntity findByName(String name);

    List<FacultyEntity> findAll();

    void deleteById(int id);
}
