package com.uleczka.deck_manager.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "deck_card")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DeckCardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deckCardIdGen")
    @SequenceGenerator(name = "deckCardIdGen", sequenceName = "deck_card_id_seq", allocationSize = 1)
    private Long id;

    private Integer konamiId;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "deck_id")
    @JsonIgnore
    private DeckEntity deck;
}
