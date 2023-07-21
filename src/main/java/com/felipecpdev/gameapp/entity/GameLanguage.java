package com.felipecpdev.gameapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "game_language")
public class GameLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference(value = "game-language-mapper")
    @ManyToOne
    private Game game;

    @ManyToOne
    @JoinColumn(name="language_id")
    private Language languagedb;

}
