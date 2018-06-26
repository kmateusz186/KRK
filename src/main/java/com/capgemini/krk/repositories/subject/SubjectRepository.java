package com.capgemini.krk.repositories.subject;

import com.capgemini.krk.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Integer> {

    SubjectEntity findByNamePl(String name);

    List<SubjectEntity> findAll();

    void deleteById(int id);
}
