package com.felipecpdev.gameapp.dto;

import com.felipecpdev.gameapp.entity.Game;
import com.felipecpdev.gameapp.entity.GameMode;
import com.felipecpdev.gameapp.entity.Mode;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class GameModeDTO implements Serializable {

    private Long id;
    private GameDTO gameDTO;
    private ModeDTO modeDTO;

    public GameModeDTO(GameMode gameMode) {
        this.id = gameMode.getId();
        this.gameDTO = new GameDTO(gameMode.getGame());
        this.modeDTO = new ModeDTO(gameMode.getMode());
    }

    public GameModeDTO(Long id, GameMode gameMode) {
        this.id = id;
        this.modeDTO = new ModeDTO(gameMode.getMode());
    }
}
