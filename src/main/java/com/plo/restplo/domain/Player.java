package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
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

    public Player(String name, Hero hero) {
        this.name = name;
        this.hero = hero;
    }


}
