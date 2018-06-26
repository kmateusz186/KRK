package com.capgemini.krk.repositories.classesType;

import com.capgemini.krk.entities.ClassestypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassesTypeRepository extends JpaRepository<ClassestypeEntity, Integer> {

    ClassestypeEntity findByName(String name);

    List<ClassestypeEntity> findAll();

    void deleteById(int id);
}
