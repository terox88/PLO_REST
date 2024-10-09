package com.plo.restplo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@AllArgsConstructor
@Getter
public class StageDto {
    private long id;
    private int numberOfRounds;
    private int stageNumber;
    private List<RoundDto> rounds;
    private InitiativeTrackDto initiativeTrackDto;
    private VukoPlateDto vukoPlateDto;
}
