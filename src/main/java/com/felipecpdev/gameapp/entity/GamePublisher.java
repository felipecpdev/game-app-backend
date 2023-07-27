package com.felipecpdev.gameapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@Table(name = "game_publisher")
public class GamePublisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "game_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Publisher publisher;
}
