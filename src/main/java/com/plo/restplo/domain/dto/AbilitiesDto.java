package com.plo.restplo.domain.dto;

import com.plo.restplo.domain.AbilitiesType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class AbilitiesDto {
    private long id;
    private final int levelOneMaxSize = 2;
    private final int levelTwoMaxSize = 3;
    private final int levelThreeMaxSize = 4;
    private List<AbilitiesType> levOneAbilitiesTypes;
    private List<AbilitiesType> levTwoAbilitiesTypes;
    private List<AbilitiesType> LevThreeAbilitiesTypes;
}
