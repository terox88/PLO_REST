package com.plo.restplo.domain;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;
@Entity(name = "GAMES")
@Getter
@Setter
@EqualsAndHashCode
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private long id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "BOARD_ID")
    private  Board board;
    private List<Player> players;
    private Player activePlayer;
    private boolean isEnded;
    private Player winner;

    public Game() {
    }

    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
    }
}
