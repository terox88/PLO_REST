package com.plo.restplo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@AllArgsConstructor
@Getter

public class BoardDto {
    private long id;
    private ViperGorgeDto viperGorgeDto;
    private List<ActionFieldDto> actionFieldsDto;
    private  List<LandDto> landsDto;
    private  List<HeroCardDto> heroCardsDto;
    private InitiativeTrackDto initiativeTrackDto;
    private int deadSnowTrack;
    private int deadSnowLimit;
    private  List<InfluenceMarkerDto> iceGarden;
}
