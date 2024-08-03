package com.plo.restplo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Queue;
@NoArgsConstructor
@Getter
public class HeroCard {
    private User user;
    private Hero hero;
    private Abilities abilities;
    private Queue<InfluenceMarker> influenceMarkers;
    private Queue<ActionMarker> actionMarkers;
    private int unitLevelOne;
    private int unitLevelTwo;
    private int unitLevelThree;
    private int gold;
    private int population;
    private int manaLevelZero;
    private int manaLevelOne;
    private int manaLevelTwo;
    private int manaLevelThree;
    private int vukoTokens;

    public HeroCard(User user, Hero hero) {
        this.user = user;
        this.hero = hero;
    }

    public void setUnitLevelOne(int unitLevelOne) {
        this.unitLevelOne = unitLevelOne;
    }

    public void setUnitLevelTwo(int unitLevelTwo) {
        this.unitLevelTwo = unitLevelTwo;
    }

    public void setUnitLevelThree(int unitLevelThree) {
        this.unitLevelThree = unitLevelThree;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setManaLevelZero(int manaLevelZero) {
        this.manaLevelZero = manaLevelZero;
    }

    public void setManaLevelOne(int manaLevelOne) {
        this.manaLevelOne = manaLevelOne;
    }

    public void setManaLevelTwo(int manaLevelTwo) {
        this.manaLevelTwo = manaLevelTwo;
    }

    public void setManaLevelThree(int manaLevelThree) {
        this.manaLevelThree = manaLevelThree;
    }

    public void setVukoTokens(int vukoTokens) {
        this.vukoTokens = vukoTokens;
    }
}
