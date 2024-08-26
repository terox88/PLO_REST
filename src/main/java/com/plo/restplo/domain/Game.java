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
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_GAME_PLAYER",
            joinColumns = {@JoinColumn(name = "GAME_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "PLAYER_ID", referencedColumnName = "ID")}
    )
    private List<Player> players;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ACTIVE_PLAYER_ID")
    private Player activePlayer;
    private boolean isEnded;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "WINNER_PLAYER_ID")
    private Player winner;

    public Game() {
    }

    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
    }
}
