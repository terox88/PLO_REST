package com.plo.restplo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@AllArgsConstructor
@Getter
public class RoundDto {
    private long id;
    private int orderNumber;
    private List<InitiativeMarkerDto> markers;
    private boolean isScoring;
    private int actionMarkersQuantity;
    private int stageNumber;
}
