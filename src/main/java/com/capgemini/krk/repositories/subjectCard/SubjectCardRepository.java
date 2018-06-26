package com.capgemini.krk.repositories.subjectCard;

import com.capgemini.krk.entities.SubjectcardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectCardRepository extends JpaRepository<SubjectcardEntity, Integer> {

    SubjectcardEntity findById(int id);

    List<SubjectcardEntity> findAll();

    void deleteById(int id);
}
