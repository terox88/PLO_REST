package com.plo.restplo.domain;

public class ActionMarker implements Unit {
    private final Color color;

    public ActionMarker(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
