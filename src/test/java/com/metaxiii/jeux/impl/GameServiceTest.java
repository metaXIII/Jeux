package com.metaxiii.jeux.impl;

import com.metaxiii.jeux.model.Game;
import com.metaxiii.jeux.repository.GameRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameServiceTest {

    @InjectMocks
    private GameService gameService;

    @Mock
    private GameRepository gameRepository;

    @Test
    void findAll() {
        assertDoesNotThrow(() -> gameService.findAll());
    }

    @Test
    void findByProgress() {
    }

    private List<Game> mockTab() {
        ArrayList<Game> arrayList = new ArrayList<>();
        arrayList.add(new Game());
        return arrayList;
    }


}