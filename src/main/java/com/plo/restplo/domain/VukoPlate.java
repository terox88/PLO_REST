package com.plo.restplo.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public class VukoPlate {
    private final VukoPlateType vukoPlateType;
    private final boolean isAllGame;

}
