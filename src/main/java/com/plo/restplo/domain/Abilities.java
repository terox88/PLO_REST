package com.plo.restplo.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Abilities {
    private final int levelOneMaxSize = 2;
    private final int levelTwoMaxSize = 3;
    private final int levelThreeMaxSize = 4;
    private final List<AbilitiesType> levOneAbilitiesTypes = new ArrayList<>();
    private final List<AbilitiesType> levTwoAbilitiesTypes = new ArrayList<>();
    private final List<AbilitiesType> LevThreeAbilitiesTypes = new ArrayList<>();


}
