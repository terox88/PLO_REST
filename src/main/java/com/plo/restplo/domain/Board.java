package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "VIPER_GORGE_ID")
    private  ViperGorge viperGorge;
    @OneToMany(
            targetEntity = ActionField.class,
            mappedBy = "board",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private  List<ActionField> actionFields;
    @OneToMany(
            targetEntity = Land.class,
            mappedBy = "board",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private  List<Land> lands;
    @OneToMany(
            targetEntity = HeroCard.class,
            mappedBy = "board",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private  List<HeroCard> heroCards;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "INITIATIVE_TRAC_ID")
    private  InitiativeTrack initiativeTrack;
    private int deadSnowTrack;
    private  int deadSnowLimit;
    @OneToMany(
            targetEntity = InfluenceMarker.class,
            mappedBy = "board",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private  List<InfluenceMarker> iceGarden;

    public Board(ViperGorge viperGorge, List<ActionField> actionFields, List<Land> lands, List<HeroCard> heroCards, InitiativeTrack initiativeTrack, int deadSnowTrack, int deadSnowLimit) {
        this.viperGorge = viperGorge;
        this.actionFields = actionFields;
        this.lands = lands;
        this.heroCards = heroCards;
        this.initiativeTrack = initiativeTrack;
        this.deadSnowTrack = deadSnowTrack;
        this.deadSnowLimit = deadSnowLimit;
        this.iceGarden = new ArrayList<>();
    }
}
