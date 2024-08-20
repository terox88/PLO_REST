package com.plo.restplo.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayDeque;
import java.util.Queue;
@RequiredArgsConstructor
@Getter
public class ActionField {
    private final ActionFieldType actionFieldType;
    private final Queue<ActionMarker> actionMarkers = new ArrayDeque<>();
    private final int maxTrackSize;
}
