package com.plo.restplo.domain;

public class Player {
    private String name;
    private String email;
    private int winningPoints;
    private int reputation;
    private boolean hasFinishedGoal;

    public Player(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
