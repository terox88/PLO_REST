package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@DynamicUpdate
public class Land {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    private int number;
    private int[] neighbors;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "LAND_TOKEN_ID")
    private LandToken landToken;
    @OneToMany(
            targetEntity = Uroczysko.class,
            mappedBy = "land",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Queue<Uroczysko> uroczyska = new ArrayDeque<>();
    private int neutralMarkerQount;
    @OneToMany(
            targetEntity = InfluenceMarker.class,
            mappedBy = "land",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<InfluenceMarker> influenceMarkers = new ArrayList<>();
    @OneToMany(
            targetEntity = SpecialUnit.class,
            mappedBy = "land",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<SpecialUnit> specialUnits = new ArrayList<>();
    private boolean hasThorn;
    private int nightmareQount;
    private boolean hasTower;
    private boolean isClosed;
    private boolean isInGame;
    private boolean hasVuko;
    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    public Land(int number, int[] neighbors, LandToken landToken, int neutralMarkerQount, Board board) {
        this.number = number;
        this.neighbors = neighbors;
        this.landToken = landToken;
        this.neutralMarkerQount = neutralMarkerQount;
        this.board = board;
    }
}
