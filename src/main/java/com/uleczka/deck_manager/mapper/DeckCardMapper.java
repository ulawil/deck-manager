package com.uleczka.deck_manager.mapper;

import com.uleczka.deck_manager.model.dto.DeckCardDto;
import com.uleczka.deck_manager.model.entity.DeckCardEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeckCardMapper {

    DeckCardDto toDeckCardDto(DeckCardEntity deckCardEntity);

    DeckCardEntity toDeckCardEntity(DeckCardDto deckCardDto);
}
