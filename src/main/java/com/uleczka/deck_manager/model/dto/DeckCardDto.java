package com.uleczka.deck_manager.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DeckCardDto {
    private Long id;
    private Integer konamiId;
    private Integer quantity;
}
