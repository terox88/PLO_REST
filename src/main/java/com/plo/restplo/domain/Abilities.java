package com.plo.restplo.domain;

import java.util.ArrayList;
import java.util.List;

public class Abilities {
    private final int levelOneMaxSize;
    private final int levelTwoMaxSize;
    private final int levelThreeMaxSize;
    private final List<AbilitiesType> levOneAbilitiesTypes = new ArrayList<>();
    private final List<AbilitiesType> levTwoAbilitiesTypes = new ArrayList<>();
    private final List<AbilitiesType> LevThreeAbilitiesTypes = new ArrayList<>();

    public Abilities(int levelOneMaxSize, int levelTwoMaxSize, int levelThreeMaxSize) {
        this.levelOneMaxSize = levelOneMaxSize;
        this.levelTwoMaxSize = levelTwoMaxSize;
        this.levelThreeMaxSize = levelThreeMaxSize;
    }

    public List<AbilitiesType> getLevOneAbilitiesTypes() {
        return levOneAbilitiesTypes;
    }

    public List<AbilitiesType> getLevTwoAbilitiesTypes() {
        return levTwoAbilitiesTypes;
    }

    public List<AbilitiesType> getLevThreeAbilitiesTypes() {
        return LevThreeAbilitiesTypes;
    }
}
