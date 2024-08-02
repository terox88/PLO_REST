package com.plo.restplo.domain;

public class InfluenceMarker implements Unit{
    private final Color color;


    public InfluenceMarker(Color color, Location location) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }


}
