package com.metaxiii.jeux.impl;

import com.metaxiii.jeux.dto.GameDto;
import com.metaxiii.jeux.model.Game;
import com.metaxiii.jeux.model.Support;
import com.metaxiii.jeux.repository.GameRepository;
import com.metaxiii.jeux.service.IGameService;
import com.metaxiii.jeux.service.ISupportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class GameService implements IGameService {

    private final GameRepository gameRepository;

    private final ISupportService supportService;

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public void insert(GameDto gameDto) throws Exception {
        Game              game = new Game();
        Optional<Support> support;
        support = supportService.findById(Integer.parseInt(gameDto.getSupport()));
        if (support.isPresent()) {
            game.setNom(gameDto.getNom());
            game.setSupport(support.get());
            game.setAvailable(true);
            game.setEnded(false);
            game.setProgress(false);
            gameRepository.save(game);
        } else
            throw new Exception("Une erreur est survenue");

    }

    @Override
    public Optional<Game> findByProgress() {
        return gameRepository.findByProgressIsTrue();
    }

    @Override
    public void pickGame() {
        Optional<Game> game = gameRepository.findByProgressIsTrueAndEndedIsFalse();
        if (game.isEmpty()) {
            List<Game> games  = gameRepository.findAllByProgressIsFalse();
            int        random = (int) (games.size() * Math.random());
            games.get(random).setProgress(true);
            gameRepository.save(games.get(random));
        }
    }

    @Override
    public void finished(int id) {
        Optional<Game> game = gameRepository.findById(id);
        game.ifPresent(jeux -> {
            jeux.setProgress(false);
            jeux.setEnded(true);
            gameRepository.save(jeux);
        });
    }
}
