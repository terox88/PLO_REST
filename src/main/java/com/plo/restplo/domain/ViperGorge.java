package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@NoArgsConstructor
@Entity
public class ViperGorge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    @Setter
    @OneToMany(
            targetEntity = ActionMarker.class,
            mappedBy = "viperGorge",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<ActionMarker> actionMarkers = new ArrayList<>();
    @Setter
    private int blackMarkers;
    @Setter
    private int redMarkers;
    @Setter
    private int greenMarkers;
    @Setter
    private int blueMarkers;
}
