package com.felipecpdev.gameapp.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "genre_name")
    private String genreName;

    @OneToMany(mappedBy = "genre")
    private Set<GameGenre> gameGenreSet = new HashSet<>();

}
