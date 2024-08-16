package com.plo.restplo.domain;

import java.util.List;
import java.util.Queue;

public class Land {
    private int number;
    private List<Integer> neighbors;
    private LandToken landToken;
    private Queue<Uroczysko> uroczyska;
    private int neutralMarkerQount;
    private List<InfluenceMarker> influenceMarkers;
    private List<SpecialUnit> specialUnits;
    private boolean hasThorn;
    private int nightmareQount;
    private boolean hasTower;
    private boolean isClosed;
    private boolean isInGame;
    private boolean hasVuko;
    private Board board;

}
