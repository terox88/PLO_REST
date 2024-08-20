package com.plo.restplo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Game {
    private final Board board;
    private final List<Player> players;
    private Player activePlayer;
    private boolean isEnded;
    private Player winner;

}
