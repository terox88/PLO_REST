package com.plo.restplo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Land {
    private final int number;
    private final List<Integer> neighbors;
    private LandToken landToken;
    private Queue<Uroczysko> uroczyska;
    private int neutralMarkerQount;
    private List<InfluenceMarker> influenceMarkers = new ArrayList<>();
    private List<SpecialUnit> specialUnits = new ArrayList<>();
    private boolean hasThorn;
    private int nightmareQount;
    private boolean hasTower;
    private boolean isClosed;
    private boolean isInGame;
    private boolean hasVuko;
    private Board board;

}
