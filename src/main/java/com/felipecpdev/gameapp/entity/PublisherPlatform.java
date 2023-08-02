package com.felipecpdev.gameapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@Table(name = "publisher_platform")
public class PublisherPlatform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "platform_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Platform platform;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Publisher publisher;

    private Date releaseDate;
}
