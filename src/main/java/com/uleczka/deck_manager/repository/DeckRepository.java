package com.uleczka.deck_manager.repository;

import com.uleczka.deck_manager.model.entity.DeckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepository extends JpaRepository<DeckEntity, Long>, PagingAndSortingRepository<DeckEntity, Long> {
}
