package com.plo.restplo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UroczyskoDto {
    private long id;
    private boolean isReal;
    private boolean isFliped;
    private LandDto landDto;
}
