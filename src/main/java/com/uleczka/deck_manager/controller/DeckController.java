package com.uleczka.deck_manager.controller;

import com.uleczka.deck_manager.DeckService;
import com.uleczka.deck_manager.model.dto.DeckDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/decks")
@RequiredArgsConstructor
public class DeckController {

    private final DeckService deckService;

    @PostMapping
    public DeckDto createDeck(@RequestBody DeckDto deckDto) {
        return deckService.createDeck(deckDto);
    }

    @GetMapping("/{id}")
    public DeckDto retrieveDeck(@PathVariable Long id) {
        return deckService.retrieveDeck(id);
    }
}
