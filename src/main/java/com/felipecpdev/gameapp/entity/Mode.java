package com.felipecpdev.gameapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "mode")
public class Mode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "mode_name")
    private String modeName;

    @OneToMany(mappedBy = "mode")
    private Set<GameMode> gameModeSet = new HashSet<>();

}
