package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayDeque;
import java.util.Queue;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class ViperGorge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    @OneToMany(
            targetEntity = ActionMarker.class,
            mappedBy = "viperGorge",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Queue<ActionMarker> actionMarkers = new ArrayDeque<>();
    private int blackMarkers;
    private int redMarkers;
    private int greenMarkers;
    private int blueMarkers;
}
