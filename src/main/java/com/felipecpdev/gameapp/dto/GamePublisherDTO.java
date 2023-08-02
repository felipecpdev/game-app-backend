package com.felipecpdev.gameapp.dto;

import com.felipecpdev.gameapp.entity.GamePublisher;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class GamePublisherDTO implements Serializable {

    private Long id;
    private GameDTO gameDTO;
    private PublisherDTO publisherDTO;

    public GamePublisherDTO(GamePublisher gamePublisher) {
        this.id = gamePublisher.getId();
        this.gameDTO = new GameDTO(gamePublisher.getGame());
        this.publisherDTO = new PublisherDTO(gamePublisher.getPublisher());
    }

    public GamePublisherDTO(Long id, GamePublisher gamePublisher) {
        this.id = id;
        this.publisherDTO = new PublisherDTO(gamePublisher.getPublisher());
    }
}
