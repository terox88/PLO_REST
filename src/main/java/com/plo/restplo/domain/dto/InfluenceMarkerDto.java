package com.plo.restplo.domain.dto;

import com.plo.restplo.domain.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InfluenceMarkerDto {
    private long id;
    private Color color;
    public final static int limit = 20;
    private HeroCardDto heroCardDto;
    private long boardId;
    private LandDto landDto;
}
