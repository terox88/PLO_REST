package com.plo.restplo.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LandToken {
    private final int order;
    private final Prize firstPrize;
    private final Prize secondPrize;
    private final Prize thirdPrize;
    private final int winnerPoints;
    private final int secondPlacePoints;
    private final int thirdPlacePoints;


}
