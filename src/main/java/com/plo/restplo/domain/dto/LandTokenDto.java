package com.plo.restplo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LandTokenDto {
    private long id;
    private int orderNumber;
    private PrizeDto manaPrize;
    private PrizeDto goldPrize;
    private PrizeDto populationPrize;
    private long gameId;
    private int winnerPoints;
    private int secondPlacePoints;
    private int thirdPlacePoints;
}
