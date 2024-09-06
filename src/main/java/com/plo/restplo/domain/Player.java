package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@DynamicUpdate
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    @ManyToOne
    @JoinColumn(name = "GAME_ID")
    private Game game;
    private String name;
    private Hero hero;
    @Setter
    private int winningPoints;
    @Setter
    private int reputation;
    @Setter
    private boolean hasWorstRep;
    @Setter
    private boolean hasFinishedGoal;

    public Player(Game game, String name, Hero hero) {
        this.game = game;
        this.name = name;
        this.hero = hero;
    }


}
