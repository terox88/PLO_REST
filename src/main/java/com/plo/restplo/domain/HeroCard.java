package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;


@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Setter
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
    private  List<InfluenceMarker> influenceMarkers;
    @OneToMany(
            targetEntity = ActionMarker.class,
            mappedBy = "heroCard",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<ActionMarker> actionMarkers;
    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;
    private int unitLevelOne;
    private int unitLevelTwo;
    private int unitLevelThree;
    private int gold;
    private int population;
    private int manaLevelZero;
    private int manaLevelOne;
    private int manaLevelTwo;
    private int manaLevelThree;

    private int vukoTokens;


    public HeroCard(Player player, Hero hero, Abilities unitsAbilities, List<InfluenceMarker> influenceMarkers, List<ActionMarker> actionMarkers, int unitLevelOne, int unitLevelTwo, int unitLevelThree, int gold, int population, int manaLevelZero) {
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
