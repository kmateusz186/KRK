package com.capgemini.krk.repositories.course;

import com.capgemini.krk.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {

    CourseEntity findById(int id);

    List<CourseEntity> findAll();

    void deleteById(int id);
}
