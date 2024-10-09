package com.plo.restplo.domain.dto;

import com.plo.restplo.domain.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ActionMarkerDto {
    private long id;
    private Color color;
    public final static int limit = 5;
    private ActionFieldDto actionFieldDto;
    private ViperGorgeDto viperGorgeDto;
    private HeroCardDto heroCardDto;
}
