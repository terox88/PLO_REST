package com.plo.restplo.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Getter
public class Stage {
    private final int numberOfRounds;
    private List<Round> rounds = new ArrayList<>();
    private VukoPlate vukoPlate;

    public void setVukoPlate(VukoPlate vukoPlate) {
        this.vukoPlate = vukoPlate;
    }
}
