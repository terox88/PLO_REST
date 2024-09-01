package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    @ManyToOne
    @JoinColumn(name = "HERO_CARD_ID")
    private HeroCard heroCard;
    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;
    @ManyToOne
    @JoinColumn(name = "LAND_ID")
    private Land land;

    public InfluenceMarker(Color color, HeroCard heroCard, Board board, Land land) {
        this.color = color;
        this.heroCard = heroCard;
        this.board = board;
        this.land = land;
    }
}
