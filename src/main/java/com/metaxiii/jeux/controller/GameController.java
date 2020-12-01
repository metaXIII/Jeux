package com.metaxiii.jeux.controller;

import com.metaxiii.jeux.dto.GameDto;
import com.metaxiii.jeux.dto.SupportDto;
import com.metaxiii.jeux.model.Game;
import com.metaxiii.jeux.service.IGameService;
import com.metaxiii.jeux.service.ISupportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class GameController {

    private final IGameService gameService;

    private final ISupportService supportService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView   modelAndView     = new ModelAndView("index");
        Optional<Game> game             = gameService.findByProgress();
        StringBuilder  stringBuilder    = new StringBuilder();
        int            sizeGameFinished = gameService.findAllFinished().size();
        int            allGameAvailable = gameService.findAllByAvailable().size();
        stringBuilder.append(sizeGameFinished);
        stringBuilder.append("/");
        stringBuilder.append(allGameAvailable);
        stringBuilder.append(" soit ");
        stringBuilder.append(String.format("%.2f", (double) (sizeGameFinished * 100) / (double) allGameAvailable));
        stringBuilder.append("% de jeux finis");
        game.ifPresent(value -> modelAndView.addObject("game", value));
        modelAndView.addObject("statistic", stringBuilder.toString());
        return modelAndView;
    }

    @GetMapping("/new-game")
    public ModelAndView insertNewGame() {
        ModelAndView modelAndView = new ModelAndView("insert");
        modelAndView.addObject("support", supportService.findAll());
        return modelAndView;
    }

    @PostMapping("/new-game")
    public ModelAndView addNewGame(@ModelAttribute GameDto gameDto) throws Exception {
        gameService.insert(gameDto);
        return index();
    }

    @PostMapping("/new-support")
    public ModelAndView addNewSupport(@ModelAttribute SupportDto supportDto) {
        supportService.insert(supportDto);
        return index();
    }

    @GetMapping("/new-console")
    public ModelAndView newConsole() {
        return new ModelAndView("console");
    }

    @GetMapping("gamePicker")
    public ModelAndView gamePicker() {
        gameService.pickGame();
        return index();
    }

    @GetMapping("finished-{id}")
    public ModelAndView finished(@PathVariable int id) {
        gameService.finished(id);
        return index();
    }
}
