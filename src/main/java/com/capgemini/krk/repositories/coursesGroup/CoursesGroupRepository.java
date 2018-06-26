package com.capgemini.krk.repositories.coursesGroup;

import com.capgemini.krk.entities.CoursesgroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursesGroupRepository extends JpaRepository<CoursesgroupEntity, Integer> {

    CoursesgroupEntity findByName(String name);

    List<CoursesgroupEntity> findAll();

    void deleteById(int id);
}
