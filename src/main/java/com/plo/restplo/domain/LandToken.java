package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@Entity
public class LandToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    private int order;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "FIRST_PRIZE_ID")
    private Prize firstPrize;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "SECOND_PRIZE_ID")
    private Prize secondPrize;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "THIRD_PRIZE_ID")
    private Prize thirdPrize;
    private int winnerPoints;
    private int secondPlacePoints;
    private int thirdPlacePoints;

    public LandToken(int order, Prize firstPrize, Prize secondPrize, Prize thirdPrize, int winnerPoints, int secondPlacePoints, int thirdPlacePoints) {
        this.order = order;
        this.firstPrize = firstPrize;
        this.secondPrize = secondPrize;
        this.thirdPrize = thirdPrize;
        this.winnerPoints = winnerPoints;
        this.secondPlacePoints = secondPlacePoints;
        this.thirdPlacePoints = thirdPlacePoints;
    }
}
