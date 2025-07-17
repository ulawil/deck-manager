package com.uleczka.deck_manager.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DeckDto {
    private Long id;
    private String name;
    private List<DeckCardDto> cards;
}
