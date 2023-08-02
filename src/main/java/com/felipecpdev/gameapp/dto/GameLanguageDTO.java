package com.felipecpdev.gameapp.dto;

import com.felipecpdev.gameapp.entity.GameLanguage;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor

public class GameLanguageDTO implements Serializable {
    private Long id;
    private GameDTO gameDTO;
    private LanguageDTO languageDTO;

    public GameLanguageDTO(GameLanguage gameLanguage) {
        this.id = gameLanguage.getId();
        this.gameDTO = new GameDTO(gameLanguage.getGame());
        this.languageDTO = new LanguageDTO(gameLanguage.getLanguagedb());
    }

    public GameLanguageDTO(Long id, GameLanguage gameLanguage) {
        this.id = id;
        this.languageDTO = new LanguageDTO(gameLanguage.getLanguagedb());
    }
}
