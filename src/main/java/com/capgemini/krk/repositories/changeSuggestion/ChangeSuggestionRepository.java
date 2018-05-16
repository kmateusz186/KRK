package com.capgemini.krk.repositories.changeSuggestion;

import com.capgemini.krk.entities.ChangesuggestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ChangeSuggestionRepository extends JpaRepository<ChangesuggestionEntity, Integer> {

    ChangesuggestionEntity findById(int id);

    List<ChangesuggestionEntity> findByIdIn(Set<Integer> idSet);

    void deleteById(int id);
}
