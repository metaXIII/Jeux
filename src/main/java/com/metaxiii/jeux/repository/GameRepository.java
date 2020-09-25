package com.metaxiii.jeux.repository;

import com.metaxiii.jeux.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    Optional<Game> findByProgressIsTrue();
    Optional<Game> findByProgressIsTrueAndEndedIsFalse();

    List<Game> findAllByProgressIsFalse();
}
