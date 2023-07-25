package com.felipecpdev.gameapp.controller;

import com.felipecpdev.gameapp.dto.GameDTO;
import com.felipecpdev.gameapp.utils.PagedResponse;
import com.felipecpdev.gameapp.entity.Game;
import com.felipecpdev.gameapp.service.GameService;
import com.felipecpdev.gameapp.utils.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<Game>> findAllGames() {
        List<Game> gameList = gameService.getAllGame();
        return new ResponseEntity<>(gameList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable long id) {
        return ResponseEntity.ok(gameService.getGameById(id));
    }

    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody Game game) {
        return ResponseEntity.ok(gameService.createGame(game));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@RequestBody Game game, @PathVariable long id) {
        game.setId(id);
        return ResponseEntity.ok(gameService.updateGame(game));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteGame(@PathVariable long id) {
        gameService.deleteGame(id);
        return HttpStatus.OK;
    }

    @GetMapping("/paginated")
    public ResponseEntity<PagedResponse<GameDTO>> getAllPosts(@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                                              @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
                                                              @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
                                                              @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
        return ResponseEntity.ok(gameService.getGamePaginated(pageNo,pageSize,sortBy,sortDir));
    }
}
