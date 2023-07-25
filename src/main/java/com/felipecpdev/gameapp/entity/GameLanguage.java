package com.felipecpdev.gameapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "game_language")
public class GameLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "game_id", foreignKey = @ForeignKey(name = "fk_game_id"))
    private Game game;

    @ManyToOne
    @JoinColumn(name = "language_id", foreignKey = @ForeignKey(name = "fk_languagedb_id"))
    private Language languagedb;

}
