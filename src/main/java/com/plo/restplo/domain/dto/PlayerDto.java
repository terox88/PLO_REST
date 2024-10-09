package com.plo.restplo.domain.dto;

import com.plo.restplo.domain.Hero;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlayerDto {
    private long id;
    private String name;
    private Hero hero;
    private int winningPoints;
    private int reputation;
    private boolean hasWorstRep;
    private boolean hasFinishedGoal;
}
