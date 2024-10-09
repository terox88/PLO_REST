package com.plo.restplo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PrizeDto {
    private long id;
    private int quantity;
    private boolean wasTaken;
}
