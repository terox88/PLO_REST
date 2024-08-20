package com.plo.restplo.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
@Getter
@Setter
public class ViperGorge {
    private final Queue<ActionMarker> actionMarkers = new ArrayDeque<>();
    private int blackMarkers;
    private int redMarkers;
    private int greenMarkers;
    private int blueMarkers;
}
