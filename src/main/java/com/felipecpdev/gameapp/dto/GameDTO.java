package com.felipecpdev.gameapp.dto;

import com.felipecpdev.gameapp.entity.Game;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class GameDTO implements Serializable {
    private Long id;
    private String gameName;
    private String developer;
    private String description;
    private String engine;
    private String gameArt;
    private boolean active;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;
    private List<GameLanguageDTO> gameLanguageDTOList;
    private List<GameGenreDTO> gameGenreDTOList;
    private List<GameModeDTO> gameModeDTOList;
    private List<GamePublisherDTO> gamePublisherDTOList;
    private List<PublisherPlatformDTO> publisherPlatformDTOList;

    public GameDTO(Game game) {
        this.id = game.getId();
        this.gameName = game.getGameName();
        this.developer = game.getDeveloper();
        this.description = game.getDescription();
        this.engine = game.getEngine();
        this.gameArt = game.getGameArt();
        this.active = game.isActive();
        this.dateCreated = game.getDateCreated();
        this.lastUpdated = game.getLastUpdated();
    }
}
