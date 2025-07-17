package com.uleczka.deck_manager.controller;

import com.uleczka.deck_manager.service.DeckService;
import com.uleczka.deck_manager.model.dto.DeckDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/decks")
@RequiredArgsConstructor
public class DeckController {

    private final DeckService deckService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public DeckDto createDeck(@RequestBody DeckDto deckDto) {
        return deckService.createDeck(deckDto);
    }

    @GetMapping(produces = "application/json")
    public List<DeckDto> retrieveAllDecks(@RequestParam(required = false, defaultValue = "0") Integer page,
                                          @RequestParam(required = false, defaultValue = "10") Integer page_size) {
        return deckService.retrieveAllDecks(page, page_size);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public DeckDto retrieveDeck(@PathVariable Long id) {
        return deckService.retrieveDeck(id);
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public DeckDto updateDeck(@RequestBody DeckDto deckDto) {
        return deckService.updateDeck(deckDto);
    }

    @DeleteMapping("/{id}")
    public void deleteDeck(@PathVariable Long id) {
        deckService.deleteDeck(id);
    }
}
