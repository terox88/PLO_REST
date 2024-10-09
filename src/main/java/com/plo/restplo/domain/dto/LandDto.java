package com.plo.restplo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@AllArgsConstructor
@Getter
public class LandDto {
    private long id;
    private int number;
    private int[] neighbors;
    private LandTokenDto landTokenDto;
    private List<UroczyskoDto> uroczyskaDto;
    private int neutralMarkerQount;
    private List<InfluenceMarkerDto> influenceMarkersDto;
    private List<SpecialUnitDto> specialUnitsDto;
    private boolean hasThorn;
    private int nightmareQount;
    private boolean hasTower;
    private boolean isClosed;
    private boolean isInGame;
    private boolean hasVuko;
    private long boardId;
}
