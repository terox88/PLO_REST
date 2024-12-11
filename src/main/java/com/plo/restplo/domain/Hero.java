package com.plo.restplo.domain;

public enum Hero {
    PIER(Color.BLACK), OLAF(Color.BLUE), ULRIKE(Color.RED), PASSIONARIA(Color.GREEN);

    private final Color color;
    Hero(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
