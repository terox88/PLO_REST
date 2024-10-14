package com.plo.restplo.domain.dto;

import com.plo.restplo.domain.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InitiativeMarkerDto {
    private long id;
    private Color color;
    private boolean twoMovesFlag;
    private int stageNumber;
    private int roundNumber;
}
