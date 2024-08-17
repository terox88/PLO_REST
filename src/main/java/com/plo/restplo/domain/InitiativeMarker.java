package com.plo.restplo.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InitiativeMarker implements Unit{
    public final static int limit = 1;
    private final Color color;
    private boolean twoMovesFlag;

    @Override
    public Color color() {
        return color;
    }

    public boolean isTwoMovesFlag() {
        return twoMovesFlag;
    }

    public void setTwoMovesFlag(boolean twoMovesFlag) {
        this.twoMovesFlag = twoMovesFlag;
    }
}
