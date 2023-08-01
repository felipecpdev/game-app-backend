package com.felipecpdev.gameapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@Table(name = "game_language")
public class GameLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id",referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_game_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Game game;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "language_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "fk_languagedb_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Language languagedb;

}
