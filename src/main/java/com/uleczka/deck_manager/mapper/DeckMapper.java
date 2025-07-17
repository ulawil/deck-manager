package com.uleczka.deck_manager.mapper;

import com.uleczka.deck_manager.model.dto.DeckDto;
import com.uleczka.deck_manager.model.entity.DeckEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeckMapper {

    DeckDto toDeckDto(DeckEntity deckEntity);

    DeckEntity toDeckEntity(DeckDto deckDto);
}
