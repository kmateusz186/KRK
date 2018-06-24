package com.capgemini.krk.repositories.moduleType;

import com.capgemini.krk.entities.ModuletypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleTypeRepository extends JpaRepository<ModuletypeEntity, Integer> {

    ModuletypeEntity findByName(String name);

    List<ModuletypeEntity> findAll();

    void deleteById(int id);
}
