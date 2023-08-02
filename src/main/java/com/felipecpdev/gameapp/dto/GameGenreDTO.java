package com.felipecpdev.gameapp.dto;

import com.felipecpdev.gameapp.entity.GameGenre;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class GameGenreDTO implements Serializable {

    private Long id;
    private GameDTO gameDTO;
    private GenreDTO genreDTO;

    public GameGenreDTO(GameGenre genre) {
        this.id = genre.getId();
        this.gameDTO = new GameDTO(genre.getGame());
        this.genreDTO = new GenreDTO(genre.getGenre());
    }

    public GameGenreDTO(Long id, GameGenre gameGenre) {
        this.id = id;
        this.genreDTO = new GenreDTO(gameGenre.getGenre());
    }
}
