package com.plo.restplo.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ActionMarker {
    private final Color color;
    public final static int limit = 5;

}
