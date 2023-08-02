package com.felipecpdev.gameapp.service.impl;

import com.felipecpdev.gameapp.dto.*;
import com.felipecpdev.gameapp.entity.*;
import com.felipecpdev.gameapp.repository.*;
import com.felipecpdev.gameapp.utils.PagedResponse;
import com.felipecpdev.gameapp.exception.ResourceNotFoundException;
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

    private final GameGenreRepository gameGenreRepository;

    private final GameModeRepository gameModeRepository;
    private final GamePublisherRepository gamePublisherRepository;
    private final PublisherPlaformRepository publisherPlaformRepository;

    public GameServiceImpl(GameRepository gameRepository, GameLanguageRepository gameLanguageRepository,
                           GameGenreRepository gameGenreRepository, GameModeRepository gameModeRepository, GamePublisherRepository gamePublisherRepository, PublisherPlaformRepository publisherPlaformRepository) {
        this.gameRepository = gameRepository;
        this.gameLanguageRepository = gameLanguageRepository;
        this.gameGenreRepository = gameGenreRepository;
        this.gameModeRepository = gameModeRepository;
        this.gamePublisherRepository = gamePublisherRepository;
        this.publisherPlaformRepository = publisherPlaformRepository;
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
    public GameDTO getGameById(long id) {
        Optional<Game> gameDb = this.gameRepository.findById(id);
        GameDTO gameDTO;
        if (gameDb.isPresent()) {
            List<GameLanguage> gameLanguageList = this.gameLanguageRepository.findByGameId(gameDb.get().getId());
            List<GameGenre> gameGenreList = this.gameGenreRepository.findByGameId(gameDb.get().getId());
            List<GameMode> gameModeList = gameModeRepository.findByGameId(gameDb.get().getId());
            List<GamePublisher> gamePublisherList = gamePublisherRepository.findByGameId(gameDb.get().getId());
            List<Publisher> publisherList = gamePublisherList.stream().map(GamePublisher::getPublisher).toList();
            List<PublisherPlatform> publisherPlatformList = publisherPlaformRepository.findByPublisherIn(publisherList);

            List<GameLanguageDTO> gameLanguageDTOList = gameLanguageList.stream()
                    .map(gameLanguage -> new GameLanguageDTO(gameLanguage.getId(), gameLanguage)).toList();
            List<GameGenreDTO> gameGenreDTOList = gameGenreList.stream()
                    .map(gameGenre -> new GameGenreDTO(gameGenre.getId(), gameGenre)).toList();
            List<GameModeDTO> gameModeDTOList = gameModeList.stream()
                    .map(gameMode -> new GameModeDTO(gameMode.getId(), gameMode)).toList();
            List<GamePublisherDTO> gamePublisherDTOList = gamePublisherList.stream()
                    .map(gamePublisher -> new GamePublisherDTO(gamePublisher.getId(), gamePublisher)).toList();
            List<PublisherPlatformDTO> publisherPlatformDTOList = publisherPlatformList.stream()
                    .map(PublisherPlatformDTO::new).toList();

            gameDTO = new GameDTO(gameDb.get());
            gameDTO.setGameLanguageDTOList(gameLanguageDTOList);
            gameDTO.setGameGenreDTOList(gameGenreDTOList);
            gameDTO.setGameModeDTOList(gameModeDTOList);
            gameDTO.setGamePublisherDTOList(gamePublisherDTOList);
            gameDTO.setPublisherPlatformDTOList(publisherPlatformDTOList);
            return gameDTO;
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
                .map(GameDTO::new)
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

}
