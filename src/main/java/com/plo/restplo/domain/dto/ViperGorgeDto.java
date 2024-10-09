package com.plo.restplo.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@AllArgsConstructor
@Getter
public class ViperGorgeDto {
    private long id;
    private List<ActionMarkerDto> actionMarkersDto;
    private int blackMarkers;
    private int redMarkers;
    private int greenMarkers;
    private int blueMarkers;
}

