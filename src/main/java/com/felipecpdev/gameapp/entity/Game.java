package com.felipecpdev.gameapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "game", uniqueConstraints = {
        @UniqueConstraint(name = "game_name_unique", columnNames = "game_name")})
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "game_name", nullable = false)
    private String gameName;
    private String developer;
    @Column(columnDefinition="TEXT")
    private String description;
    private String engine;
    @Column(name = "game_art")
    private String gameArt;
    private boolean active;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    @JsonManagedReference(value = "game-language-mapper")
    @OneToMany(mappedBy = "game",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GameLanguage> gameLanguageList;

    @JsonIgnore
    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<GameGenre> gameGenreSet = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<GamePublisher> gamePublisherSet = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<GameMode> gameModeSet = new HashSet<>();
}
