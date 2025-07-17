package com.uleczka.deck_manager;

import com.uleczka.deck_manager.mapper.DeckMapper;
import com.uleczka.deck_manager.model.dto.DeckDto;
import com.uleczka.deck_manager.model.entity.DeckEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeckService {

    private final DeckRepository deckRepository;
    private final DeckMapper deckMapper;

    @Transactional
    public DeckDto createDeck(DeckDto deckDto) {
        DeckEntity newDeck = deckMapper.toDeckEntity(deckDto);
        newDeck.getCards().forEach(deckCardEntity -> deckCardEntity.setDeck(newDeck));
        return deckMapper.toDeckDto(deckRepository.save(newDeck));
    }

    public DeckDto retrieveDeck(Long deckId) {
        return deckRepository.findById(deckId)
                .map(deckMapper::toDeckDto)
                .orElseThrow(); // todo define custom exception
    }
}
