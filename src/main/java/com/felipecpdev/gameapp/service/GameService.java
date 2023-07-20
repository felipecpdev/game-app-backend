package com.felipecpdev.gameapp.service;

import com.felipecpdev.gameapp.entity.Game;

import java.util.List;

public interface GameService {

    Game createGame(Game game);

    Game updateGame(Game game);

    List<Game> getAllGame();

    Game getGameById(long id);

    void deleteGame(long id);
}