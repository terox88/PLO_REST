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
    private  ViperGorge viperGorge;
    private  List<ActionField> actionFields;
    private  List<Land> lands;
    private  List<HeroCard> heroCards;
    private  InitiativeTrack initiativeTrack;
    private int deadSnowTrack;
    private  int deadSnowLimit;
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
