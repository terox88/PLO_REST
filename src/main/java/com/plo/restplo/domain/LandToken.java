package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@DynamicUpdate
public class LandToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    private int orderNumber;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "MANA_PRIZE_ID")
    private Prize manaPrize;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "GOLD_PRIZE_ID")
    private Prize goldPrize;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "POPULATION_PRIZE_ID")
    private Prize populationPrize;
    @Setter
    @ManyToOne
    @JoinColumn(name = "GAME_ID")
    private Game game;
    private int winnerPoints;
    private int secondPlacePoints;
    private int thirdPlacePoints;

    public LandToken(int orderNumber, Prize manaPrize, Prize goldPrize, Prize populationPrize, int winnerPoints, int secondPlacePoints, int thirdPlacePoints) {
        this.orderNumber = orderNumber;
        this.manaPrize = manaPrize;
        this.goldPrize = goldPrize;
        this.populationPrize = populationPrize;
        this.winnerPoints = winnerPoints;
        this.secondPlacePoints = secondPlacePoints;
        this.thirdPlacePoints = thirdPlacePoints;
    }
}
