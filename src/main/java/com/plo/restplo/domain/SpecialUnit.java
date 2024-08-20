package com.plo.restplo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class SpecialUnit {
    private final String name;
    private final Color color;
    private final int level;
   private boolean isKilled;


}
