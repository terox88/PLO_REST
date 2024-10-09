package com.plo.restplo.domain.dto;

import com.plo.restplo.domain.VukoPlateType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class VukoPlateDto {
    private long id;
    private VukoPlateType vukoPlateType;
    private boolean isAllGame;
}
