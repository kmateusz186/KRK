package com.capgemini.krk.repositories.kind;

import com.capgemini.krk.entities.KindEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KindRepository extends JpaRepository<KindEntity, Integer> {

    KindEntity findByName(String name);

    List<KindEntity> findAll();

    void deleteById(int id);
}
