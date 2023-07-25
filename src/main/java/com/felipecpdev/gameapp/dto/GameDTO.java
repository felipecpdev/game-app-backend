package com.felipecpdev.gameapp.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GameDTO {
    private Long id;
    private String gameName;
    private String developer;
    private String description;
    private String engine;
    private String gameArt;
    private boolean active;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;
}
