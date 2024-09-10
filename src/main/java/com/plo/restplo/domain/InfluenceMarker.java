package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class InfluenceMarker  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    private  Color color;
    public final static int limit = 20;
    @Setter
    @ManyToOne
    @JoinColumn(name = "HERO_CARD_ID")
    private HeroCard heroCard;
    @Setter
    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;
    @Setter
    @ManyToOne
    @JoinColumn(name = "LAND_ID")
    private Land land;

    public InfluenceMarker(Color color) {
        this.color = color;

    }
}
