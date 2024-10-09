package com.plo.restplo.domain.dto;

import com.plo.restplo.domain.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class HeroCardDto {
    private long id;
    private PlayerDto playerDto;
    private Hero hero;
    private AbilitiesDto unitsAbilities;
    private List<InfluenceMarkerDto> influenceMarkersDto;
    private List<ActionMarkerDto> actionMarkersDto;
    private long boardId;
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
}
