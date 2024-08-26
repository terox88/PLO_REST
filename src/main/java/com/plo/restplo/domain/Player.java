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
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "players")
    private List<Game> games;
    private String name;
    private String email;
    @Setter
    private int winningPoints;
    @Setter
    private int reputation;
    @Setter
    private boolean hasWorstRep;
    @Setter
    private boolean hasFinishedGoal;

    public Player(List<Game> games, String name, String email) {
        this.games = games;
        this.name = name;
        this.email = email;
    }


}
