package com.felipecpdev.gameapp.service.impl;

import com.felipecpdev.gameapp.dto.GameDTO;
import com.felipecpdev.gameapp.utils.PagedResponse;
import com.felipecpdev.gameapp.entity.Game;
import com.felipecpdev.gameapp.entity.GameLanguage;
import com.felipecpdev.gameapp.exception.ResourceNotFoundException;
import com.felipecpdev.gameapp.repository.GameLanguageRepository;
import com.felipecpdev.gameapp.repository.GameRepository;
import com.felipecpdev.gameapp.service.GameService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final GameLanguageRepository gameLanguageRepository;

    public GameServiceImpl(GameRepository gameRepository, GameLanguageRepository gameLanguageRepository) {
        this.gameRepository = gameRepository;
        this.gameLanguageRepository = gameLanguageRepository;
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
            gameUpdate.setActive(game.isActive());
            gameRepository.save(gameUpdate);
            return gameUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + game.getId());
        }
    }

    @Override
    public List<Game> getAllGame() {
        List<Long> gameIdList = new ArrayList<>();
        List<GameLanguage> gameLanguageList = gameLanguageRepository.findAllById(gameIdList);
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

    @Override
    public PagedResponse<GameDTO> getGamePaginated(int pageNo, int pageSize, String sortBy, String sortDir, String name) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Game> gamePage;
        if (!Objects.equals(name, "")) {
            gamePage = gameRepository.findByGameNameContainsIgnoreCase(name, pageable);
        } else {
            gamePage = gameRepository.findAll(pageable);
        }
        List<Game> gameList = gamePage.getContent();
        List<GameDTO> content = gameList.stream()
                .map(game -> mapToDTO(game))
                .collect(Collectors.toList());

        PagedResponse<GameDTO> gameResponse = new PagedResponse<>();
        gameResponse.setContent(content);
        gameResponse.setPageNo(gamePage.getNumber());
        gameResponse.setPageSize(gamePage.getSize());
        gameResponse.setTotalElements(gamePage.getTotalElements());
        gameResponse.setTotalPages(gamePage.getTotalPages());
        gameResponse.setLast(gamePage.isLast());
        return gameResponse;
    }

    // convert Entity into DTO
    private GameDTO mapToDTO(Game game) {
        GameDTO gameDTO = new GameDTO();
        gameDTO.setId(game.getId());
        gameDTO.setGameName(game.getGameName());
        gameDTO.setDeveloper(game.getDeveloper());
        gameDTO.setDescription(game.getDescription());
        gameDTO.setEngine(game.getEngine());
        gameDTO.setGameArt(game.getGameArt());
        gameDTO.setActive(game.isActive());
        gameDTO.setDateCreated(game.getDateCreated());
        gameDTO.setLastUpdated(game.getLastUpdate());
        return gameDTO;
    }
}
