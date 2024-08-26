package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Land {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    private final int number;
    private final int[] neighbors;
    private LandToken landToken;
    @OneToMany(
            targetEntity = Uroczysko.class,
            mappedBy = "land",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Queue<Uroczysko> uroczyska = new ArrayDeque<>();
    private int neutralMarkerQount;
    private List<InfluenceMarker> influenceMarkers = new ArrayList<>();
    private List<SpecialUnit> specialUnits = new ArrayList<>();
    private boolean hasThorn;
    private int nightmareQount;
    private boolean hasTower;
    private boolean isClosed;
    private boolean isInGame;
    private boolean hasVuko;
    private Board board;

}
