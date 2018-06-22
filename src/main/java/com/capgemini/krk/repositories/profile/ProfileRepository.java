package com.capgemini.krk.repositories.profile;

import com.capgemini.krk.entities.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Integer> {

    ProfileEntity findByName(String name);

    List<ProfileEntity> findAll();

    void deleteById(int id);
}
