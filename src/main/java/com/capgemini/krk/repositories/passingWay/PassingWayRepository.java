package com.capgemini.krk.repositories.passingWay;

import com.capgemini.krk.entities.PassingwayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassingWayRepository extends JpaRepository<PassingwayEntity, Integer> {

    PassingwayEntity findByName(String name);

    List<PassingwayEntity> findAll();

    void deleteById(int id);
}
