package com.plo.restplo.domain.dto;

import com.plo.restplo.domain.ActionFieldType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@AllArgsConstructor
@Getter
public class ActionFieldDto {
    private long id;
    private ActionFieldType actionFieldType;

    private List<ActionMarkerDto> actionMarkersDto;
    private  int maxTrackSize;

    private long boardId;
}
