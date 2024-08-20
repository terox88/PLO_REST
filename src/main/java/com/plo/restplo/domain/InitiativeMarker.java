package com.plo.restplo.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class InitiativeMarker {
    public final static int limit = 1;
    private final Color color;
    private boolean twoMovesFlag;


    public void setTwoMovesFlag(boolean twoMovesFlag) {
        this.twoMovesFlag = twoMovesFlag;
    }
}
