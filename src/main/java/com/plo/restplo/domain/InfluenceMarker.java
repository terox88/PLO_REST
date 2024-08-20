package com.plo.restplo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class InfluenceMarker  {
    private final Color color;
    public final static int limit = 20;


}
