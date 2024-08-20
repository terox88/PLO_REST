package com.plo.restplo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class Board {
    private final Game game;
    private final ViperGorge viperGorge;
    private final List<ActionField> actionFields;
    private final List<Land> lands;
    private final List<HeroCard> heroCards;
    private final InitiativeTrack initiativeTrack;
    private int deadSnowTrack;
    private final int deadSnowLimit;
    private final List<InfluenceMarker> iceGarden;


}
