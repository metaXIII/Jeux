package com.metaxiii.jeux.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameDtoTest {

    private GameDto gameDto;

    @BeforeEach
    public void init() {
        gameDto = new GameDto();
        gameDto.setId(1);
    }

    @Test
    void getId() {
        assertEquals(1, gameDto.getId());
    }

    @Test
    void setId() {
        assertDoesNotThrow(() -> gameDto.setId(2));
    }
}