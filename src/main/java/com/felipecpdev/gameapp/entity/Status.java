package com.felipecpdev.gameapp.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "status_name")
    private String statusName;
}
