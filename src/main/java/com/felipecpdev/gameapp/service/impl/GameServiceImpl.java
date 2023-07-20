package com.felipecpdev.gameapp.service.impl;

import com.felipecpdev.gameapp.entity.Game;
import com.felipecpdev.gameapp.exception.ResourceNotFoundException;
import com.felipecpdev.gameapp.repository.GameRepository;
import com.felipecpdev.gameapp.service.GameService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    @Transactional
    public Game updateGame(Game game) {
        Optional<Game> gameDb = this.gameRepository.findById(game.getId());
        if (gameDb.isPresent()) {
            Game gameUpdate = gameDb.get();
            gameUpdate.setGameName(game.getGameName());
            gameUpdate.setDeveloper(game.getDeveloper());
            gameUpdate.setDescription(game.getDescription());
            gameUpdate.setEngine(game.getEngine());
            gameUpdate.setGameArt(game.getGameArt());
            gameUpdate.setActive(gameUpdate.isActive());
            gameRepository.save(gameUpdate);
            return gameUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + game.getId());
        }
    }

    @Override
    public List<Game> getAllGame() {
        return gameRepository.findAll();
    }

    @Override
    public Game getGameById(long id) {
        Optional<Game> gameDb = this.gameRepository.findById(id);
        if (gameDb.isPresent()) {
            return gameDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

    @Override
    @Transactional
    public void deleteGame(long id) {
        Optional<Game> gameDb = this.gameRepository.findById(id);
        if (gameDb.isPresent()) {
            gameRepository.delete(gameDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }
}
