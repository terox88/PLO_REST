package com.plo.restplo.domain.dto;

import com.plo.restplo.domain.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SpecialUnitDto {
    private long id;
    private  String name;
    private Color color;
    private int level;
    private boolean isKilled;
    private LandDto landDto;
}
