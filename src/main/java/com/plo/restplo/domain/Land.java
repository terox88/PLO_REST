package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

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
    private List<Uroczysko> uroczyska = new ArrayList<>();
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

    public Land(int number, int[] neighbors, int neutralMarkerQount) {
        this.number = number;
        this.neighbors = neighbors;
        this.neutralMarkerQount = neutralMarkerQount;

    }
}
