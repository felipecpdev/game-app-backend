package com.felipecpdev.gameapp.service;

import com.felipecpdev.gameapp.dto.GameDTO;
import com.felipecpdev.gameapp.utils.PagedResponse;
import com.felipecpdev.gameapp.entity.Game;

import java.util.List;

public interface GameService {

    Game createGame(Game game);

    Game updateGame(Game game);

    List<Game> getAllGame();

    GameDTO getGameById(long id);

    void deleteGame(long id);

    PagedResponse<GameDTO> getGamePaginated(int pageNo, int pageSize, String sortBy, String sortDir, String name);

}