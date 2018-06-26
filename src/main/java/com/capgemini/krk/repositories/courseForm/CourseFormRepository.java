package com.capgemini.krk.repositories.courseForm;

import com.capgemini.krk.entities.CourseformEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseFormRepository extends JpaRepository<CourseformEntity, Integer> {

    CourseformEntity findByName(String name);

    List<CourseformEntity> findAll();

    void deleteById(int id);
}
