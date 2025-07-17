package com.uleczka.deck_manager.service;

import com.uleczka.deck_manager.mapper.DeckMapper;
import com.uleczka.deck_manager.model.dto.DeckDto;
import com.uleczka.deck_manager.model.entity.DeckEntity;
import com.uleczka.deck_manager.repository.DeckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<DeckDto> retrieveAllDecks(Integer page, Integer pageSize) {
        return deckRepository.findAll(Pageable.ofSize(pageSize).withPage(page))
                .stream()
                .map(deckMapper::toDeckDto)
                .toList();
    }

    @Transactional
    public DeckDto updateDeck(DeckDto deckDto) {
        if (deckDto.getId() == null || !deckRepository.existsById(deckDto.getId())) {
            throw new IllegalStateException(); // todo define custom exception
        }
        DeckEntity updatedDeck = deckMapper.toDeckEntity(deckDto);
        updatedDeck.getCards().forEach(deckCardEntity -> deckCardEntity.setDeck(updatedDeck));

        return deckMapper.toDeckDto(deckRepository.save(updatedDeck));
    }

    @Transactional
    public void deleteDeck(Long id) {
        if (!deckRepository.existsById(id)) {
            throw new IllegalStateException(); // todo define custom exception
        }
        deckRepository.deleteById(id);
    }
}
