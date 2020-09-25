package com.metaxiii.jeux.service;

import com.metaxiii.jeux.dto.GameDto;
import com.metaxiii.jeux.model.Game;

import java.util.List;
import java.util.Optional;

public interface IGameService {
    List<Game> findAll();

    void insert(GameDto gameDto) throws Exception;

    Optional<Game> findByProgress();

    void pickGame();

    void finished(int id);
}
