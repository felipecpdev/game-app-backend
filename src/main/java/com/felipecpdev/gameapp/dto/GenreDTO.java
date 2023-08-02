package com.felipecpdev.gameapp.dto;

import com.felipecpdev.gameapp.entity.Genre;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class GenreDTO implements Serializable {

    private Long id;
    private String genreName;

    public GenreDTO(Genre genre) {
        this.id = genre.getId();
        this.genreName = genre.getGenreName();
    }
}
