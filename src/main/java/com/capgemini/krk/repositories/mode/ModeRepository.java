package com.capgemini.krk.repositories.mode;

import com.capgemini.krk.entities.ModeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModeRepository extends JpaRepository<ModeEntity, Integer> {

    ModeEntity findByName(String name);

    List<ModeEntity> findAll();

    void deleteById(int id);
}
