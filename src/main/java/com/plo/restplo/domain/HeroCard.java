package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Queue;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@DynamicUpdate
public class HeroCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PLAYER_ID")
    private  Player player;
    private  Hero hero;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ABILITIES_ID")
    private  Abilities unitsAbilities;
    @OneToMany(
            targetEntity = InfluenceMarker.class,
            mappedBy = "heroCard",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private  Queue<InfluenceMarker> influenceMarkers;
    @OneToMany(
            targetEntity = ActionMarker.class,
            mappedBy = "heroCard",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private  Queue<ActionMarker> actionMarkers;
    @Setter
    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;
    @Setter
    private int unitLevelOne;
    @Setter
    private int unitLevelTwo;
    @Setter
    private int unitLevelThree;
    @Setter
    private int gold;
    @Setter
    private int population;
    @Setter
    private int manaLevelZero;
    @Setter
    private int manaLevelOne;
    @Setter
    private int manaLevelTwo;
    @Setter
    private int manaLevelThree;
    @Setter
    private int vukoTokens;


    public HeroCard(Player player, Hero hero, Abilities unitsAbilities, Queue<InfluenceMarker> influenceMarkers, Queue<ActionMarker> actionMarkers, int unitLevelOne, int unitLevelTwo, int unitLevelThree, int gold, int population, int manaLevelZero) {
        this.player = player;
        this.hero = hero;
        this.unitsAbilities = unitsAbilities;
        this.influenceMarkers = influenceMarkers;
        this.actionMarkers = actionMarkers;
        this.unitLevelOne = unitLevelOne;
        this.unitLevelTwo = unitLevelTwo;
        this.unitLevelThree = unitLevelThree;
        this.gold = gold;
        this.population = population;
        this.manaLevelZero = manaLevelZero;
    }
}
