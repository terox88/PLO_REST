package com.plo.restplo.domain.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@AllArgsConstructor
@Getter
public class InitiativeTrackDto {
    private long id;
    private List<StageDto> stagesDto;
}
