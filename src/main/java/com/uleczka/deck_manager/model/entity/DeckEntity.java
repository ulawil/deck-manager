package com.uleczka.deck_manager.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "deck")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DeckEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deckIdGen")
    @SequenceGenerator(name = "deckIdGen", sequenceName = "deck_id_seq", allocationSize = 1)

    private Long id;

    private String name;

    @OneToMany(mappedBy = "deck", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DeckCardEntity> cards;
}
