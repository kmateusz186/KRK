package com.capgemini.krk.repositories.courseType;

import com.capgemini.krk.entities.CoursetypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseTypeRepository extends JpaRepository<CoursetypeEntity, Integer> {

    CoursetypeEntity findByName(String name);

    List<CoursetypeEntity> findAll();

    void deleteById(int id);
}
