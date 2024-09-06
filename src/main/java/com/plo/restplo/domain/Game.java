package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;
@Entity(name = "GAMES")
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "BOARD_ID")
    private  Board board;
    @OneToMany(
            targetEntity = Player.class,
            mappedBy = "game",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Player> players;
    @Setter
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ACTIVE_PLAYER_ID")
    private Player activePlayer;
    @Setter
    private boolean isEnded;
    @Setter
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "WINNER_PLAYER_ID")
    private Player winner;


    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
    }
}
