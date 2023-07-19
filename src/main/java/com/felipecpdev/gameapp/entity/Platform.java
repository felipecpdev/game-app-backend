package com.felipecpdev.gameapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "platform")
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "platform_name")
    private String platformName;

    @OneToMany(mappedBy = "platform")
    private Set<PublisherPlatform> publisherPlatformSet = new HashSet<>();
}
